package com.example.mvvmsampleapp.country


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetCountryUseCase
import com.example.mvvmsampleapp.mapper.MapperForDomainAndPresenter
import javax.inject.Inject

class ViewModelFactory @Inject
constructor(private val useCase: GetCountryUseCase, val mapper: CountryMapper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountryViewModel(useCase, mapper) as T
    }
}
