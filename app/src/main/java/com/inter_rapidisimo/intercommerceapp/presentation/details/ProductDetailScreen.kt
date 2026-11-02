package com.inter_rapidisimo.intercommerceapp.presentation.details


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.presentation.details.widgets.ProductDetailContent
import com.inter_rapidisimo.intercommerceapp.presentation.product.ProductViewModel
@Composable
fun ProductDetailScreen(
    navController: NavController,
    productId: Int,
    viewModel: ProductViewModel = hiltViewModel()
) {

    val product by viewModel.selectedProduct.collectAsState()

    val isLoading by viewModel.isLoading.collectAsState()

    val error by viewModel.error.collectAsState()

    LaunchedEffect(productId) {
        viewModel.loadProduct(productId)
    }

    when {

        isLoading -> {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                CircularProgressIndicator()
            }
        }

        error != null -> {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Text(error ?: "Error")
            }
        }

        product != null -> {

            ProductDetailContent(
                product = product!!,
                onBackClick = {
                    navController.popBackStack()
                },
                onAddToCart = { product ->
                    viewModel.addToCart(product)
                }
            )
        }

    }
}

