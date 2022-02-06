package com.nurtdinov.simpleshop.data.remote.model


import com.google.gson.annotations.SerializedName
import com.nurtdinov.simpleshop.data.local.entity.ResultEntity

data class ResultItemDto(
    @SerializedName("best_seller")
    val bestSeller: List<BestSellerDto>,
    @SerializedName("home_store")
    val homeStore: List<HomeStoreDto>,
    @SerializedName("_id")
    val id: String
){
    fun toResultEntity():ResultEntity{
        return ResultEntity(
            bestSeller = bestSeller.map { it.toBestSeller() },
            homeStore = homeStore.map { it.toHomeStore() },
            id = id
        )
    }

}