package com.inter_rapidisimo.intercommerceapp.presentation.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inter_rapidisimo.intercommerceapp.application.KtorClient.KtorClient
import com.inter_rapidisimo.intercommerceapp.data.source.remote.api.ApiRoutes
import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.domain.product.ProductList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val ktorClient: KtorClient
) : ViewModel() {
    
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchProducts(limit: Int = 10, skip: Int = 0) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            try {
                val url = "${ApiRoutes.PRODUCTS_LIST}?limit=$limit&skip=$skip"
                val productList = ktorClient.get<ProductList>(url)
                
                productList?.let {
                    _products.value = it.products
                } ?: run {
                    _error.value = "No se pudieron cargar los productos"
                }
            } catch (e: Exception) {
                _error.value = "Error al cargar productos: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
