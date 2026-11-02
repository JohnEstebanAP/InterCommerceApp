package com.inter_rapidisimo.intercommerceapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.inter_rapidisimo.intercommerceapp.data.source.local.entity.CartEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM cart")
    fun getCartItems(): Flow<List<CartEntity>>

    @Query("SELECT * FROM cart WHERE productId = :id LIMIT 1")
    suspend fun getById(id: Int): CartEntity?

    @Insert
    suspend fun insert(item: CartEntity)

    @Update
    suspend fun update(item: CartEntity)

    @Delete
    suspend fun delete(item: CartEntity)

    @Query("DELETE FROM cart WHERE productId = :productId")
    suspend fun deleteById(productId: Int)
}