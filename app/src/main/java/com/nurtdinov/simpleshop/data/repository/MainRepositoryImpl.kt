package com.nurtdinov.simpleshop.data.repository

import com.nurtdinov.simpleshop.core.util.Resource
import com.nurtdinov.simpleshop.data.local.room.ShopDao
import com.nurtdinov.simpleshop.data.remote.retrofit.ShopApi
import com.nurtdinov.simpleshop.domain.repository.MainRepository
import com.nurtdinov.simpleshop.domain.model.ResultItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class MainRepositoryImpl @Inject constructor(
    private val api: ShopApi,
    private val dao: ShopDao
) : MainRepository {

    override fun getPhonesList(): Flow<Resource<List<ResultItem>>> = flow {
        emit(Resource.Loading())

        val phonesList = dao.getAllPhones().map { it.toResultItem() }
        emit(Resource.Loading(data = phonesList))

        try {
            val remotePhonesList = api.getPhonesList()
            dao.insertAllPhones(remotePhonesList.map { it.toResultEntity() })

        } catch (e: HttpException) {
            emit(Resource.Error(
                "Error",
                data = phonesList
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                "Server = true , check internet",
                data = phonesList
            ))
        }
        val newPhonesList = dao.getAllPhones().map { it.toResultItem() }
        emit(Resource.Success(newPhonesList))
    }

}



