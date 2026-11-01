package com.inter_rapidisimo.intercommerceapp.domain.product

import kotlinx.serialization.Serializable

@Serializable
data class ProductList(
    val total: Int = 0,
    val skip: Int = 0,
    val limit: Int = 0,
    val products: List<Product> = emptyList()
)
