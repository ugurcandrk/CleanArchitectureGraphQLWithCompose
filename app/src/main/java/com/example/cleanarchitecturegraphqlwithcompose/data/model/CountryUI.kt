package com.example.cleanarchitecturegraphqlwithcompose.data.model

data class CountryUI(
    val name: String?,
    val phone: String?,
    val capital: String?,
    val currency: String?,
    val languages: List<LanguageUI>?,
    val emoji: String?,
)