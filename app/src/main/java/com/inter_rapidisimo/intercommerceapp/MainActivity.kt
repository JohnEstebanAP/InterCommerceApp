package com.inter_rapidisimo.intercommerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.inter_rapidisimo.intercommerceapp.presentation.product.ProductScreen
import com.inter_rapidisimo.intercommerceapp.ui.theme.InterCommerceAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InterCommerceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    ProductScreen(paddingValues)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InterCommerceAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            ProductScreen(paddingValues)
        }
    }
}
