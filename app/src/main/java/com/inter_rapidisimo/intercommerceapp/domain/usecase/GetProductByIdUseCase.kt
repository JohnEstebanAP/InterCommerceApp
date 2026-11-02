package com.inter_rapidisimo.intercommerceapp.domain.usecase


import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(
        productId: Int
    ): Product? {

        return repository.getProductById(
            productId
        )
    }
}