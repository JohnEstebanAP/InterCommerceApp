package com.inter_rapidisimo.intercommerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.inter_rapidisimo.intercommerceapp.presentation.home.HomeScreen
import com.inter_rapidisimo.intercommerceapp.presentation.navigation.AppNavigation
import com.inter_rapidisimo.intercommerceapp.presentation.splash.OfflineSplashScreen
import com.inter_rapidisimo.intercommerceapp.presentation.splash.SplashScreen
import com.inter_rapidisimo.intercommerceapp.ui.theme.InterCommerceAppTheme
import com.inter_rapidisimo.intercommerceapp.utils.rememberIsNetworkConnected
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InterCommerceAppTheme {
                val isOnline by rememberIsNetworkConnected()
                var showSplash by remember { mutableStateOf(true) }

                Crossfade(
                    targetState = Pair(showSplash, isOnline),
                    animationSpec = tween(durationMillis = 500),
                    label = "SplashCrossfade"
                ) { (isSplashVisible, online) ->
                    if (isSplashVisible) {
                        if (online) {
                            SplashScreen(
                                onSplashFinished = {
                                    showSplash = false
                                }
                            )
                        } else {
                            OfflineSplashScreen(
                                onExploreOfflineCatalog = {
                                    showSplash = false
                                }
                            )
                        }
                    } else {
                        Surface {
                            AppNavigation()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InterCommerceAppTheme {
        AppNavigation()
    }
}
