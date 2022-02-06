package com.nurtdinov.simpleshop.data.remote.retrofit

import com.nurtdinov.simpleshop.core.util.API_KEY
import com.nurtdinov.simpleshop.data.remote.model.ResultItemDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface ShopApi {

    @Headers("x-apikey: $API_KEY")
    @GET("/rest/home")
    suspend fun getPhonesList(): List<ResultItemDto>
}