package com.inter_rapidisimo.intercommerceapp.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.inter_rapidisimo.intercommerceapp.data.source.local.dao.ProductDao
import com.inter_rapidisimo.intercommerceapp.data.source.local.entity.ProductEntity

@Database(
    entities = [
        ProductEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}