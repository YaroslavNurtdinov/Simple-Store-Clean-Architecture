package com.nurtdinov.simpleshop.presenter.di

import com.nurtdinov.simpleshop.domain.repository.MainRepository
import com.nurtdinov.simpleshop.domain.use_case.GetPhonesListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {



    @Provides
    fun provideGetPhonesListUseCase(mainRepository: MainRepository):GetPhonesListUseCase{
        return GetPhonesListUseCase(repository = mainRepository)
    }

}