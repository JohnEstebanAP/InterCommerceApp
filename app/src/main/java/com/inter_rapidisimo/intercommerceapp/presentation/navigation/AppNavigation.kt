package com.inter_rapidisimo.intercommerceapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.inter_rapidisimo.intercommerceapp.presentation.ui.cart.CartScreen
import com.inter_rapidisimo.intercommerceapp.presentation.ui.details.ProductDetailScreen
import com.inter_rapidisimo.intercommerceapp.presentation.ui.home.HomeScreen
import com.inter_rapidisimo.intercommerceapp.presentation.ui.product.ProductScreen

@Composable
fun AppNavigation() {

    val navController =
        rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.Home.route
    ) {

        composable(
            AppRoutes.Home.route
        ) {
            HomeScreen(
                navController = navController
            )
        }

        composable(
            route = AppRoutes.Products.route,
        ) {
            ProductScreen(
                navController = navController
            )
        }

        composable(
            route = AppRoutes.ProductDetail.route,
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.IntType
                }
            )
        ) {
            val productId = it.arguments?.getInt("productId") ?: 0

            ProductDetailScreen(
                productId = productId,
                navController = navController
            )
        }

        composable(
            route = AppRoutes.cart.route,
        ) {
            CartScreen(
                navController = navController
            )
        }
    }
}