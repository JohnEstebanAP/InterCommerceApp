package com.inter_rapidisimo.intercommerceapp.data.repository

import com.inter_rapidisimo.intercommerceapp.application.KtorClient.KtorClient
import com.inter_rapidisimo.intercommerceapp.data.mapper.toDomain
import com.inter_rapidisimo.intercommerceapp.data.mapper.toEntity
import com.inter_rapidisimo.intercommerceapp.data.source.local.dao.ProductDao
import com.inter_rapidisimo.intercommerceapp.data.source.remote.api.ApiRoutes
import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.domain.product.ProductList
import com.inter_rapidisimo.intercommerceapp.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(

    private val api: KtorClient,
    private val dao: ProductDao

) : ProductRepository {

    override suspend fun getProducts(limit: Int, skip: Int): List<Product> {

        return try {

            val response = api.get<ProductList>(
                "${ApiRoutes.PRODUCTS_LIST}?limit=$limit&skip=$skip",
            ) ?: throw Exception("No internet")

            val products = response.products

            dao.deleteProducts()

            dao.insertProducts(
                products.map {
                    it.toEntity()
                }
            )

            products

        } catch (e: Exception) {

            dao.getProducts().map {
                it.toDomain()
            }
        }
    }

    override suspend fun getProductById(
        id: Int
    ): Product? {

        return dao.getProductById(id)
            ?.toDomain()
    }
}