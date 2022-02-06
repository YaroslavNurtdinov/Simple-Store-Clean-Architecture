package com.nurtdinov.simpleshop.domain.use_case

import com.nurtdinov.simpleshop.core.util.Resource
import com.nurtdinov.simpleshop.domain.repository.MainRepository
import com.nurtdinov.simpleshop.domain.model.ResultItem
import kotlinx.coroutines.flow.Flow

class GetPhonesListUseCase(private val repository: MainRepository) {

   fun getData(): Flow<Resource<List<ResultItem>>>{
        return repository.getPhonesList()
    }

}