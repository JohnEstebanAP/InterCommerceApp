package com.inter_rapidisimo.intercommerceapp.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
}