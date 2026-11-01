package com.inter_rapidisimo.intercommerceapp.data.source.remote.api

object ApiRoutes {
    private const val BASE_URL = "https://dummyjson.com"
    
    // Listado y Paginación
    const val PRODUCTS_LIST = "$BASE_URL/products"
    
    // Búsqueda
    const val PRODUCTS_SEARCH = "$BASE_URL/products/search"
    
    // Detalle
    const val PRODUCT_DETAIL = "$BASE_URL/products/"
}