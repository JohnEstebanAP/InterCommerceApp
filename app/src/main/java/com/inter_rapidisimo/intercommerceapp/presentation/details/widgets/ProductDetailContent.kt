package com.inter_rapidisimo.intercommerceapp.presentation.details.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.inter_rapidisimo.intercommerceapp.domain.product.Product

@Composable
fun ProductDetailContent(
    product: Product,
    onBackClick: () -> Unit,
    onAddToCart: (Product) -> Unit
) {

    Scaffold(
        containerColor = Color(0xFFF5F5F5)
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {

            ProductHeader(
                onBackClick = onBackClick
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProductImage(
                imageUrl = product.thumbnail
            )

            Spacer(modifier = Modifier.height(20.dp))

            ProductInformation(
                product = product
            )

            Spacer(modifier = Modifier.height(32.dp))

            AddToCartButton {
                onAddToCart(product)
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}