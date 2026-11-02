package com.inter_rapidisimo.intercommerceapp.data.di

import android.content.Context
import androidx.room.Room
import com.inter_rapidisimo.intercommerceapp.application.KtorClient.KtorClient
import com.inter_rapidisimo.intercommerceapp.data.repository.CartRepositoryImpl
import com.inter_rapidisimo.intercommerceapp.data.repository.ProductRepositoryImpl
import com.inter_rapidisimo.intercommerceapp.data.source.local.dao.ProductDao
import com.inter_rapidisimo.intercommerceapp.data.source.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.inter_rapidisimo.intercommerceapp.data.source.local.dao.CartDao
import com.inter_rapidisimo.intercommerceapp.domain.repository.CartRepository
import com.inter_rapidisimo.intercommerceapp.domain.repository.ProductRepository
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideKtorClient(): KtorClient {
        return KtorClient()
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {

        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "intercommerce_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductDao(
        database: AppDatabase
    ): ProductDao {

        return database.productDao()
    }

    @Provides
    @Singleton
    fun provideCartDao(
        database: AppDatabase
    ): CartDao {

        return database.cartDao()
    }
    @Provides
    @Singleton
    fun provideProductRepository(
        api: KtorClient,
        dao: ProductDao
    ): ProductRepository {
        return ProductRepositoryImpl(api, dao)
    }

    @Provides
    @Singleton
    fun provideCartRepository(
        cartDao: CartDao
    ): CartRepository {

        return CartRepositoryImpl(
            cartDao
        )
    }
}