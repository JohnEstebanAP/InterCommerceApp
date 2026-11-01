package com.inter_rapidisimo.intercommerceapp.application.KtorClient

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class KtorClient {
    val client: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
                coerceInputValues = true
            })
        }

        install(Logging) {
            level = LogLevel.INFO
        }
    }

    suspend inline fun <reified T> get(url: String): T? {
        return try {
            val response = client.get(url)
            response.body<T>()
        } catch (e: Exception) {
            println("Error en la solicitud GET a $url: ${e.message}")
            e.printStackTrace()
            null
        }
    }

    // Overload para compatibilidad con llamadas que pasen Class<T>
    suspend inline fun <reified T> get(url: String, responseType: Class<T>): T? {
        return get<T>(url)
    }

    suspend inline fun <reified T> post(url: String, requestBody: Any): T? {
        return try {
            val response = client.post(url) {
                contentType(ContentType.Application.Json)
                setBody(requestBody)
            }
            response.body<T>()
        } catch (e: Exception) {
            println("Error en la solicitud POST a $url: ${e.message}")
            e.printStackTrace()
            null
        }
    }

    suspend inline fun <reified T> post(url: String, requestBody: Any, responseType: Class<T>): T? {
        return post<T>(url, requestBody)
    }

    suspend inline fun <reified T> put(url: String, requestBody: Any): T? {
        return try {
            val response = client.put(url) {
                contentType(ContentType.Application.Json)
                setBody(requestBody)
            }
            response.body<T>()
        } catch (e: Exception) {
            println("Error en la solicitud PUT a $url: ${e.message}")
            e.printStackTrace()
            null
        }
    }

    suspend inline fun <reified T> put(url: String, requestBody: Any, responseType: Class<T>): T? {
        return put<T>(url, requestBody)
    }

    suspend fun delete(url: String): Boolean {
        return try {
            val response = client.delete(url)
            response.status.isSuccess()
        } catch (e: Exception) {
            println("Error en la solicitud DELETE a $url: ${e.message}")
            e.printStackTrace()
            false
        }
    }
}
