package com.inter_rapidisimo.intercommerceapp.domain.product

import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val barcode: String? = null,
    val qrCode: String? = null
)
