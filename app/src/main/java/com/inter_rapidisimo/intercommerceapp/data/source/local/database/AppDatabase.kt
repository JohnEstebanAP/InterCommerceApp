package com.inter_rapidisimo.intercommerceapp.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.inter_rapidisimo.intercommerceapp.data.source.local.dao.CartDao
import com.inter_rapidisimo.intercommerceapp.data.source.local.dao.ProductDao
import com.inter_rapidisimo.intercommerceapp.data.source.local.entity.ProductEntity
import com.inter_rapidisimo.intercommerceapp.data.source.local.entity.CartEntity

@Database(
    entities = [
        ProductEntity::class,
        CartEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    abstract fun cartDao(): CartDao
}