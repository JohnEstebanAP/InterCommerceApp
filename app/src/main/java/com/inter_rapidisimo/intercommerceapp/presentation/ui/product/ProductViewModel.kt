package com.inter_rapidisimo.intercommerceapp.presentation.ui.product

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
    private var currentSkip = 0

    private val pageSize = 10

    private var isLastPage = false
    fun fetchProducts(limit: Int = pageSize, skip: Int = 0) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                val products = getProductsUseCase(limit, skip)

                currentSkip = products.size
                isLastPage = products.isEmpty()

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

    fun loadMoreProducts() {

        if (_isLoading.value) return

        if (isLastPage) return

        viewModelScope.launch {

            _isLoading.value = true

            try {

                val newProducts = getProductsUseCase(
                    pageSize,
                    currentSkip
                )

                if (newProducts.isEmpty()) {

                    isLastPage = true

                } else {

                    _products.value =
                        _products.value + newProducts

                    currentSkip += newProducts.size
                }

            } catch (e: Exception) {

                _error.value =
                    "Error al cargar más productos"

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
