package com.inter_rapidisimo.intercommerceapp.presentation.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.domain.usecase.AddToCartUseCase
import com.inter_rapidisimo.intercommerceapp.domain.usecase.GetProductByIdUseCase
import com.inter_rapidisimo.intercommerceapp.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val addToCartUseCase: AddToCartUseCase
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _selectedProduct = MutableStateFlow<Product?>(null)

    val selectedProduct: StateFlow<Product?> = _selectedProduct

    fun fetchProducts(limit: Int = 10, skip: Int = 0) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                val products = getProductsUseCase(limit, skip)

                if (products.isNotEmpty()) {
                    _products.value = products
                } else {
                    _error.value = "No se pudieron cargar los productos"
                }
            } catch (e: Exception) {
                _error.value = "Error al cargar productos: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadProduct(
        productId: Int
    ) {

        viewModelScope.launch {

            _isLoading.value = true

            try {

                _selectedProduct.value = getProductByIdUseCase(productId)

            } catch (e: Exception) {

                _error.value = e.message ?: "Error"

            } finally {

                _isLoading.value = false
            }
        }
    }

    fun addToCart(product: Product) {

        viewModelScope.launch {
            addToCartUseCase(product)
        }
    }

}
