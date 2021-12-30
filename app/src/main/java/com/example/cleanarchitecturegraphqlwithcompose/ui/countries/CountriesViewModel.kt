package com.example.cleanarchitecturegraphqlwithcompose.ui.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturegraphqlwithcompose.data.model.CountryUI
import com.example.cleanarchitecturegraphqlwithcompose.data.model.ResultModel
import com.example.cleanarchitecturegraphqlwithcompose.domain.interactor.CountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val countriesUseCase: CountriesUseCase,
) : ViewModel() {

    val error = MutableLiveData<String?>()

    private val _countries = MutableLiveData<List<CountryUI>>()
    val countries: LiveData<List<CountryUI>> = _countries

    init {
        getCountries()
    }

     fun getCountries() {

        viewModelScope.launch {
            when (val result = countriesUseCase.execute()) {
                is ResultModel.Success -> {
                    result.data?.let { data ->
                        _countries.value = data
                    }
                }
                is ResultModel.Error -> {
                    error.value = result.message
                }
            }
        }
    }
}