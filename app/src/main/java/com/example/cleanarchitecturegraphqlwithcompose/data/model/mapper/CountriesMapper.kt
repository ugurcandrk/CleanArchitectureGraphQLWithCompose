package com.example.cleanarchitecturegraphqlwithcompose.data.model.mapper

import com.example.cleanarchitecturegraphqlwithcompose.CountriesQuery
import com.example.cleanarchitecturegraphqlwithcompose.data.model.CountryUI
import com.example.cleanarchitecturegraphqlwithcompose.data.model.LanguageUI
import javax.inject.Inject

class CountriesMapper @Inject constructor() {

    fun convert(data: CountriesQuery.Data?): List<CountryUI>? {
        return data?.countries?.map { country ->
            CountryUI(
                name = country.name,
                code = country.code,
                phone = country.phone,
                capital = country.capital,
                currency = country.currency,
                languages = convertLanguages(country.languages),
                emoji = country.emoji
            )
        }
    }

    private fun convertLanguages(languages: List<CountriesQuery.Language>): List<LanguageUI> {
        return languages.map { language ->
            LanguageUI(
                name = language.name
            )
        }
    }
}