package com.nurtdinov.simpleshop.presenter.screens.viewmodel

import androidx.lifecycle.*
import com.nurtdinov.simpleshop.core.util.Resource
import com.nurtdinov.simpleshop.domain.model.ResultItem
import com.nurtdinov.simpleshop.domain.use_case.GetPhonesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    getPhonesList: GetPhonesListUseCase
) : ViewModel() {

    private val _phonesList: LiveData<Resource<List<ResultItem>>> =
        getPhonesList.getData().asLiveData()

    val phonesList: LiveData<Resource<List<ResultItem>>> = _phonesList






}


