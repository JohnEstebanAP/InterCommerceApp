package com.inter_rapidisimo.intercommerceapp.presentation.cart

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.inter_rapidisimo.intercommerceapp.data.source.local.entity.CartEntity

@Composable
fun CartScreen(
    navController: NavController,
    viewModel: CartViewModel = hiltViewModel()
) {

    val items by viewModel.cartItems.collectAsState()

    val total by viewModel.total.collectAsState()

    LazyColumn {

        item {

            Text(
                text = "Mi carrito"
            )
        }

        items(items) { item ->

            CartItemCard(
                item = item
            )
        }

        item {

            Text(
                text = "Total: $$total"
            )
        }
    }
}

@Composable
fun CartItemCard(item: CartEntity) {
    TODO("Not yet implemented")
}
