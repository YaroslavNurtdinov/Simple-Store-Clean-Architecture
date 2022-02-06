package com.nurtdinov.simpleshop.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

import com.nurtdinov.simpleshop.domain.model.BestSeller
import com.nurtdinov.simpleshop.domain.model.HomeStore
import com.nurtdinov.simpleshop.domain.model.ResultItem


@Entity(tableName = "shop_table")
data class ResultEntity(
    @PrimaryKey(autoGenerate = false) val newId:Int =0,
    val bestSeller: List<BestSeller>,
    val homeStore: List<HomeStore>,
    val id: String
) {
    fun toResultItem(): ResultItem{
        return ResultItem(
            bestSeller = bestSeller,
            homeStore = homeStore,
            id = id
        )
    }
}