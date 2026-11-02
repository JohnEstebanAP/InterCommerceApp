package com.inter_rapidisimo.intercommerceapp.data.repository

import com.inter_rapidisimo.intercommerceapp.data.source.local.dao.CartDao
import com.inter_rapidisimo.intercommerceapp.data.source.local.entity.CartEntity
import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val cartDao: CartDao
) : CartRepository {
    override fun getCartItems(): Flow<List<CartEntity>> {
        return cartDao.getCartItems()
    }

    override suspend fun addToCart(
        product: Product
    ) {

        val existing =
            cartDao.getById(product.id)

        if (existing != null) {

            cartDao.update(
                existing.copy(
                    quantity = existing.quantity + 1
                )
            )

        } else {

            cartDao.insert(
                CartEntity(
                    productId = product.id,
                    title = product.title,
                    price = product.price,
                    thumbnail = product.thumbnail,
                    quantity = 1
                )
            )
        }
    }

    override suspend fun updateQuantity(productId: Int, quantity: Int) {
        val item =
            cartDao.getById(productId)

        if (item != null) {

            cartDao.update(
                item.copy(
                    quantity = quantity
                )
            )

        }
    }

    override suspend fun removeItem(productId: Int) {
        cartDao.deleteById(
            productId
        )
    }
}
