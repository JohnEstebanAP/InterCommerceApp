package com.inter_rapidisimo.intercommerceapp.domain.product

import kotlinx.serialization.Serializable

@Serializable
data class Review(
    val rating: Int = 0,
    val comment: String = "",
    val date: String = "",
    val reviewerName: String = "",
    val reviewerEmail: String = ""
)
