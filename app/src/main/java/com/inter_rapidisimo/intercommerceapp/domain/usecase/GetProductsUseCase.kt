package com.inter_rapidisimo.intercommerceapp.domain.usecase

import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.domain.repository.ProductRepository
import jakarta.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(
        limit: Int,
        skip: Int
    ): List<Product> {

        return repository.getProducts(
            limit = limit,
            skip = skip
        )
    }


}