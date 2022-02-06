package com.nurtdinov.simpleshop.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nurtdinov.simpleshop.data.local.entity.ResultEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ShopDao {

    @Query("SELECT * FROM shop_table")
    suspend fun getAllPhones(): List<ResultEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPhones(resultEntity: List<ResultEntity>)
}