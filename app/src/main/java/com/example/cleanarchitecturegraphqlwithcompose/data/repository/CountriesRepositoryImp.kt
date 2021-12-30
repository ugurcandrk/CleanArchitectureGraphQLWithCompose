package com.example.cleanarchitecturegraphqlwithcompose.data.repository

import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.ApolloClient
import com.example.cleanarchitecturegraphqlwithcompose.CountriesQuery
import com.example.cleanarchitecturegraphqlwithcompose.domain.CountriesRepository
import javax.inject.Inject

class CountriesRepositoryImp @Inject constructor(
    private val apolloClient: ApolloClient,
) : CountriesRepository {

    override suspend fun getCountries(): ApolloCall<CountriesQuery.Data> =
        apolloClient.query(CountriesQuery())
}