package com.nurtdinov.simpleshop.data.local.utilit

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nurtdinov.simpleshop.domain.model.BestSeller
import com.nurtdinov.simpleshop.domain.model.HomeStore

class Converter {

    var gson = Gson()

    @TypeConverter
    fun bestSellerToString(bestSeller: List<BestSeller>): String {
        return gson.toJson(bestSeller)
    }

    @TypeConverter
    fun stringToBestSeller(data:String):List<BestSeller>{
        val listType = object : TypeToken<List<BestSeller>>(){}.type
        return gson.fromJson(data,listType)
    }

    @TypeConverter
    fun homeStoreToString(homeStore: List<HomeStore>): String {
        return gson.toJson(homeStore)
    }

    @TypeConverter
    fun stringToHomeStore(data:String):List<HomeStore>{
        val listType = object : TypeToken<List<HomeStore>>(){}.type
        return gson.fromJson(data,listType)
    }
}