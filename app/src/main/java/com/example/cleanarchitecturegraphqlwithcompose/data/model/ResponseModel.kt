package com.example.cleanarchitecturegraphqlwithcompose.data.model

sealed class ResultModel<T>(
    val data: T? = null,
    val message: String? = null,
) {
    class Success<T>(data: T) : ResultModel<T>(data)
    class Error<T>(message: String?, data: T? = null) : ResultModel<T>(data, message)
}