package com.nurtdinov.simpleshop.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nurtdinov.simpleshop.data.local.entity.ResultEntity
import com.nurtdinov.simpleshop.data.local.utilit.Converter

@Database(
    entities = [ResultEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class ShopDatabase :RoomDatabase(){

    abstract fun shopDao():ShopDao

}