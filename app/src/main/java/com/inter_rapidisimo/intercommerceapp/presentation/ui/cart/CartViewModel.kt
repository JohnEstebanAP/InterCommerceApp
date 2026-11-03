package com.inter_rapidisimo.intercommerceapp.presentation.ui.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inter_rapidisimo.intercommerceapp.data.source.local.entity.CartEntity
import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.domain.repository.CartRepository
import com.inter_rapidisimo.intercommerceapp.domain.usecase.AddToCartUseCase
import com.inter_rapidisimo.intercommerceapp.domain.usecase.CalculateCartTotalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: CartRepository,
    private val calculateCartTotalUseCase: CalculateCartTotalUseCase,
    private val addToCartUseCase: AddToCartUseCase
) : ViewModel() {

    val cartItems =
        repository.getCartItems()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(),
                emptyList()
            )

    val total = MutableStateFlow(0.0)

    init {

        viewModelScope.launch {

            cartItems.collect {

                total.value =
                    calculateCartTotalUseCase(it)
            }
        }
    }

    fun addToCart(product: Product) {
        viewModelScope.launch {
            addToCartUseCase(product)
        }
    }

    fun increaseQuantity(item: CartEntity) {
        viewModelScope.launch {

            repository.updateQuantity(
                productId = item.productId,
                quantity = item.quantity + 1
            )
        }
    }

    fun decreaseQuantity(item: CartEntity) {
        viewModelScope.launch {

            if (item.quantity > 1) {

                repository.updateQuantity(
                    productId = item.productId,
                    quantity = item.quantity - 1
                )
            } else {
                repository.removeItem(item.productId)
            }
        }
    }

    fun removeItem(item: CartEntity) {
        viewModelScope.launch {
            repository.removeItem(item.productId)
        }
    }
}