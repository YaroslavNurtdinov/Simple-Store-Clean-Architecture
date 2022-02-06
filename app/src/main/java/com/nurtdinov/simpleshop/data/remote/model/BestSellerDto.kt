package com.nurtdinov.simpleshop.data.remote.model


import com.google.gson.annotations.SerializedName
import com.nurtdinov.simpleshop.domain.model.BestSeller

data class BestSellerDto(
    @SerializedName("discount_price")
    val discountPrice: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_favorites")
    val isFavorites: Boolean,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("price_without_discount")
    val priceWithoutDiscount: Int,
    @SerializedName("title")
    val title: String
) {

    fun toBestSeller(): BestSeller {
        return BestSeller(
            discountPrice = discountPrice,
            id = id,
            isFavorites = isFavorites,
            picture = picture,
            priceWithoutDiscount = priceWithoutDiscount,
            title = title
        )
    }
}