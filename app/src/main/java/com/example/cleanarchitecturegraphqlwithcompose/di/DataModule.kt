package com.example.cleanarchitecturegraphqlwithcompose.di

import com.example.cleanarchitecturegraphqlwithcompose.data.repository.CountriesRepositoryImp
import com.example.cleanarchitecturegraphqlwithcompose.domain.CountriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun getCountries(
        countriesRepository: CountriesRepositoryImp,
    ): CountriesRepository
}