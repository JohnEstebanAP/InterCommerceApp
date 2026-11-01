package com.inter_rapidisimo.intercommerceapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.inter_rapidisimo.intercommerceapp.data.source.local.entity.ProductEntity

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    suspend fun getProducts(): List<ProductEntity>

    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getProductById(
        id: Int
    ): ProductEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(
        products: List<ProductEntity>
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(
        product: ProductEntity
    )

    @Query("DELETE FROM products")
    suspend fun deleteProducts()
}