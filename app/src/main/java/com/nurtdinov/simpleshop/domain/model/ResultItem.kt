package com.nurtdinov.simpleshop.domain.model


import com.google.gson.annotations.SerializedName

data class ResultItem(
    @SerializedName("best_seller")
    val bestSeller: List<BestSeller>,
    @SerializedName("home_store")
    val homeStore: List<HomeStore>,
    @SerializedName("_id")
    val id: String
)