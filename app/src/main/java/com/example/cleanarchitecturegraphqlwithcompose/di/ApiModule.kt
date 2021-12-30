package com.example.cleanarchitecturegraphqlwithcompose.di.module

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Singleton
    @Provides
    fun provideApolloClient(
        okHttpClient: OkHttpClient,
    ): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/")
            .okHttpClient(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder().let { okHttpBuilder ->

            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
                okHttpBuilder.addInterceptor(this)
                /* timeout, default değeri 10 saniye
                     .connectTimeout(10, TimeUnit.SECONDS)
                     .readTimeout(10, TimeUnit.SECONDS)*/
            }
            okHttpBuilder.build()
        }
    }
}