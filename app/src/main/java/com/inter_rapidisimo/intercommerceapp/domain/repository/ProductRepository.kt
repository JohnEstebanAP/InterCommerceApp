package com.inter_rapidisimo.intercommerceapp.domain.repository

import com.inter_rapidisimo.intercommerceapp.domain.product.Product

interface ProductRepository {

    suspend fun getProducts(limit: Int, skip: Int): List<Product>

    suspend fun getProductById(
        id: Int
    ): Product?
}