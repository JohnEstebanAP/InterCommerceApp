package com.inter_rapidisimo.intercommerceapp.domain.product

import kotlinx.serialization.Serializable

@Serializable
data class Dimensions(
    val width: Double = 0.0,
    val height: Double = 0.0,
    val depth: Double = 0.0
)
