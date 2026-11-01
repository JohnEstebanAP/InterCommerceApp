package com.inter_rapidisimo.intercommerceapp.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged

object NetworkUtils {

    /**
     * Valida sincrónicamente si hay conexión a Internet en el dispositivo.
     */
    @SuppressLint("MissingPermission")
    fun isInternetAvailable(context: Context): Boolean {
        return try {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
                    ?: return false

            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val capabilities =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

            capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } catch (_: Exception) {
            false
        }
    }

    /**
     * Retorna un Flow que emite en tiempo real si el dispositivo está conectado a Internet.
     */
    @SuppressLint("MissingPermission")
    fun observeNetworkStatus(context: Context): Flow<Boolean> = callbackFlow {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager

        if (connectivityManager == null) {
            trySend(false)
            close()
            return@callbackFlow
        }

        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                trySend(true)
            }

            override fun onLost(network: Network) {
                trySend(false)
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                val hasInternet =
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                            networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                trySend(hasInternet)
            }
        }

        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        try {
            connectivityManager.registerNetworkCallback(request, callback)
        } catch (_: Exception) {
            trySend(false)
        }

        // Emitir estado inicial
        trySend(isInternetAvailable(context))

        awaitClose {
            try {
                connectivityManager.unregisterNetworkCallback(callback)
            } catch (_: Exception) {}
        }
    }.distinctUntilChanged()
}

/**
 * Composable helper para observar el estado de red en Compose.
 */
@SuppressLint("MissingPermission")
@Composable
fun rememberIsNetworkConnected(): State<Boolean> {
    val context = LocalContext.current.applicationContext
    val isConnectedState = remember { mutableStateOf(NetworkUtils.isInternetAvailable(context)) }

    DisposableEffect(context) {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager

        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                isConnectedState.value = true
            }

            override fun onLost(network: Network) {
                isConnectedState.value = false
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                val hasInternet =
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                            networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                isConnectedState.value = hasInternet
            }
        }

        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        try {
            connectivityManager?.registerNetworkCallback(request, callback)
        } catch (_: Exception) {
            isConnectedState.value = false
        }

        onDispose {
            try {
                connectivityManager?.unregisterNetworkCallback(callback)
            } catch (_: Exception) {}
        }
    }

    return isConnectedState
}
