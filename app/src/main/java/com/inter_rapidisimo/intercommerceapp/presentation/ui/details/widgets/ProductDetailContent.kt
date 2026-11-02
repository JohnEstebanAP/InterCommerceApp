package com.inter_rapidisimo.intercommerceapp.presentation.ui.details.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
@Composable
fun ProductDetailContent(
    modifier: Modifier = Modifier,
    product: Product,
    onBackClick: () -> Unit,
    onAddToCart: (Product) -> Unit
) {
    var isAddingToCart by remember {
        mutableStateOf(false)
    }

    val haptic = LocalHapticFeedback.current

    val snackbarHostState = remember { SnackbarHostState() }

    val scope = rememberCoroutineScope()

    Scaffold(
        containerColor = Color(0xFFF5F5F5),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {

            ProductHeader(
                modifier = modifier,
                onBackClick = onBackClick
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProductImage(
                modifier = modifier,
                imageUrl = product.thumbnail
            )

            Spacer(modifier = Modifier.height(20.dp))

            ProductInformation(
                modifier = modifier,
                product = product
            )

            Spacer(modifier = Modifier.height(32.dp))

            AddToCartButton(
                modifier = modifier,
                enabled = !isAddingToCart
            ) {
                if (isAddingToCart) return@AddToCartButton

                isAddingToCart = true

                onAddToCart(product)

                haptic.performHapticFeedback(
                    HapticFeedbackType.LongPress
                )

                scope.launch {

                    snackbarHostState.showSnackbar(
                        message = "Producto agregado al carrito"
                    )

                    delay(500)

                    isAddingToCart = false
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}