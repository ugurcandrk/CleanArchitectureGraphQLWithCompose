package com.example.cleanarchitecturegraphqlwithcompose.domain

import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.api.ApolloResponse
import com.example.cleanarchitecturegraphqlwithcompose.CountriesQuery

interface CountriesRepository {

    suspend fun getCountries(): ApolloCall<CountriesQuery.Data>
}