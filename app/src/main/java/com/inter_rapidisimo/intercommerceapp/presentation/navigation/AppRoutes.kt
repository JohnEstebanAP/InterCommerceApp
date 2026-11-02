package com.inter_rapidisimo.intercommerceapp.presentation.navigation

sealed class AppRoutes(
    val route: String
) {

    data object Home :
        AppRoutes("home")

    data object ProductDetail :
        AppRoutes("product_detail/{productId}") {

        fun createRoute(
            productId: Int
        ): String {
            return "product_detail/$productId"
        }
    }

    data object Products :
        AppRoutes("products") {
    }

    data object cart :
        AppRoutes("cart") {
    }
}