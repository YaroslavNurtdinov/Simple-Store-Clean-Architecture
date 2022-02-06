package com.nurtdinov.simpleshop.presenter.di

import android.content.Context
import androidx.room.Room
import com.nurtdinov.simpleshop.core.util.DATABASE_NAME
import com.nurtdinov.simpleshop.data.local.room.ShopDao
import com.nurtdinov.simpleshop.data.local.room.ShopDatabase
import com.nurtdinov.simpleshop.data.remote.retrofit.ShopApi
import com.nurtdinov.simpleshop.data.repository.MainRepositoryImpl
import com.nurtdinov.simpleshop.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideMainRepository(shopApi: ShopApi, shopDao: ShopDao): MainRepository {
        return MainRepositoryImpl(api = shopApi, dao = shopDao)
    }

    @Singleton
    @Provides
    fun providesDao(shopDatabase:ShopDatabase) = shopDatabase.shopDao()

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        ShopDatabase::class.java,
        DATABASE_NAME
    ).build()



}