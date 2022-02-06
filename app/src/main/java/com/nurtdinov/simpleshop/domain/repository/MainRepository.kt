package com.nurtdinov.simpleshop.domain.repository

import com.nurtdinov.simpleshop.core.util.Resource
import com.nurtdinov.simpleshop.domain.model.ResultItem
import kotlinx.coroutines.flow.Flow

interface MainRepository {

fun getPhonesList():Flow<Resource<List<ResultItem>>>

}