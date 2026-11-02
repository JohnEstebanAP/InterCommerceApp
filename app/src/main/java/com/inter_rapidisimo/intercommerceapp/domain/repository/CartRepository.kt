package com.inter_rapidisimo.intercommerceapp.domain.repository

import com.inter_rapidisimo.intercommerceapp.data.source.local.entity.CartEntity
import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getCartItems(): Flow<List<CartEntity>>

    suspend fun addToCart(
        product: Product
    )

    suspend fun updateQuantity(
        productId: Int,
        quantity: Int
    )

    suspend fun removeItem(
        productId: Int
    )
}