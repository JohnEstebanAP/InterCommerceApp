package com.inter_rapidisimo.intercommerceapp.data.mapper

import com.inter_rapidisimo.intercommerceapp.data.source.local.entity.ProductEntity
import com.inter_rapidisimo.intercommerceapp.domain.product.Product

fun Product.toEntity(): ProductEntity {

    return ProductEntity(
        id = id,
        title = title,
        description = description,
        category = category,
        price = price,
        rating = rating,
        stock = stock,
        thumbnail = thumbnail
    )
}

fun ProductEntity.toDomain(): Product {

    return Product(
        id = id,
        title = title,
        description = description,
        category = category,
        price = price,
        rating = rating,
        stock = stock,
        thumbnail = thumbnail
    )
}