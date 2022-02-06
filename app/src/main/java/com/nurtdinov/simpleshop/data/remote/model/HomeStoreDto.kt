package com.nurtdinov.simpleshop.data.remote.model


import com.google.gson.annotations.SerializedName
import com.nurtdinov.simpleshop.domain.model.HomeStore

data class HomeStoreDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_buy")
    val isBuy: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String
) {
    fun toHomeStore(): HomeStore {
        return HomeStore(
            id = id,
            isBuy = isBuy,
            isNew = isNew,
            picture = picture,
            subtitle = subtitle,
            title = title
        )
    }

}