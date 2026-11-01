package com.inter_rapidisimo.intercommerceapp.domain.product

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val category: String = "",
    val price: Double = 0.0,
    val discountPercentage: Double = 0.0,
    val rating: Double = 0.0,
    val stock: Int = 0,
    val tags: List<String> = emptyList(),
    val brand: String? = null,
    val sku: String? = null,
    val weight: Int = 0,
    val dimensions: Dimensions? = null,
    val warrantyInformation: String? = null,
    val shippingInformation: String? = null,
    val availabilityStatus: String? = null,
    val reviews: List<Review> = emptyList(),
    val returnPolicy: String? = null,
    val minimumOrderQuantity: Int = 0,
    val meta: Meta? = null,
    val images: List<String> = emptyList(),
    val thumbnail: String = ""
)
