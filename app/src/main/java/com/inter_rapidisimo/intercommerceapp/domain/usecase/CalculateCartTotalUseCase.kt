package com.inter_rapidisimo.intercommerceapp.domain.usecase

import com.inter_rapidisimo.intercommerceapp.data.source.local.entity.CartEntity
import javax.inject.Inject

class CalculateCartTotalUseCase @Inject constructor() {

    operator fun invoke(
        items: List<CartEntity>
    ): Double {

        return items.sumOf {
            it.price * it.quantity
        }
    }
}