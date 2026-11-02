package com.inter_rapidisimo.intercommerceapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.presentation.home.utils.skeleton
import com.inter_rapidisimo.intercommerceapp.presentation.home.widget.BestSellersSection
import com.inter_rapidisimo.intercommerceapp.presentation.home.widget.FastShippingInfoCard
import com.inter_rapidisimo.intercommerceapp.presentation.home.widget.FeaturedProductsSection
import com.inter_rapidisimo.intercommerceapp.presentation.home.widget.HomeBottomNavigationBar
import com.inter_rapidisimo.intercommerceapp.presentation.home.widget.HomeCategoryShortcuts
import com.inter_rapidisimo.intercommerceapp.presentation.product.ProductViewModel
import com.inter_rapidisimo.intercommerceapp.presentation.home.widget.HomePromoBanner
import com.inter_rapidisimo.intercommerceapp.presentation.home.widget.HomeHeaderSection
import kotlin.random.Random
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.inter_rapidisimo.intercommerceapp.presentation.navigation.AppRoutes

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: ProductViewModel? = if (LocalInspectionMode.current) null else hiltViewModel()
) {
    if (viewModel != null) {
        val products by viewModel.products.collectAsState()
        val isLoading by viewModel.isLoading.collectAsState()
        val error by viewModel.error.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.fetchProducts(limit = 10, skip = Random.nextInt(0, 100))
        }

        HomeScreenContent(
            navController = navController,
            products = products,
            isLoading = isLoading,
            error = error
        )
    } else {
        HomeScreenContent(
            navController = navController,
            products = emptyList(),
            isLoading = false,
            error = null
        )
    }
}

@Composable
fun HomeScreenContent(
    navController: NavController,
    products: List<Product> = emptyList(),
    isLoading: Boolean = false,
    error: String? = null
) {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            HomeBottomNavigationBar(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(paddingValues)
                .skeleton(isLoading)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                // Header (Yellow Brand Area)
                HomeHeaderSection(modifier = Modifier.skeleton(isLoading))

                // Main Content Body
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(22.dp)
                ) {

                    // Promo Banner Card
                    HomePromoBanner(modifier = Modifier.skeleton(isLoading))

                    // Shipping Proposition Pill
                    FastShippingInfoCard(modifier = Modifier.skeleton(isLoading))

                    // Category Shortcuts
                    HomeCategoryShortcuts(modifier = Modifier.skeleton(isLoading))

                    // Section 1: Más vendidos (Consuming API Products)
                    BestSellersSection(
                        products = products,
                        isLoading = isLoading,
                        error = error,
                        modifier = Modifier.skeleton(isLoading),
                        onProductClick = { product ->
                            navController.navigate(
                                AppRoutes.ProductDetail.createRoute(
                                    product.id
                                )
                            )
                        }
                    )

                    // Section 2: Productos destacados (Consuming API Products)
                    FeaturedProductsSection(
                        products = products,
                        isLoading = isLoading,
                        modifier = Modifier.skeleton(isLoading)
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController() // Create a NavController instance
    HomeScreenContent(navController = navController) // Pass the NavController to HomeScreenContent
}
