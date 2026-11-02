package com.inter_rapidisimo.intercommerceapp.domain.usecase

import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.domain.repository.CartRepository
import javax.inject.Inject

class AddToCartUseCase @Inject constructor(
    private val repository: CartRepository
) {

    suspend operator fun invoke(
        product: Product
    ) {
        repository.addToCart(product)
    }
}