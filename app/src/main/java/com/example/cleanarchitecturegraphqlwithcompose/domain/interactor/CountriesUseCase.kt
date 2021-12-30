package com.example.cleanarchitecturegraphqlwithcompose.domain.interactor

import com.apollographql.apollo3.exception.ApolloException
import com.example.cleanarchitecturegraphqlwithcompose.data.model.CountryUI
import com.example.cleanarchitecturegraphqlwithcompose.data.model.ResultModel
import com.example.cleanarchitecturegraphqlwithcompose.data.model.mapper.CountriesMapper
import com.example.cleanarchitecturegraphqlwithcompose.domain.CountriesRepository
import javax.inject.Inject

class CountriesUseCase @Inject constructor(
    private val countriesRepository: CountriesRepository,
    private val countriesMapper: CountriesMapper,
) {

    suspend fun execute(): ResultModel<List<CountryUI>?> {
        return try {
            countriesRepository.getCountries().execute().run {
                if (hasErrors()) {
                    ResultModel.Error(errors?.first()?.message)
                } else {
                    ResultModel.Success(countriesMapper.convert(data))
                }
            }
        } catch (error: ApolloException) {
            ResultModel.Error(error.localizedMessage)
        }
    }
}