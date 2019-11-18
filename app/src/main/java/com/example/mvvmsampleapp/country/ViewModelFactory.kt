package com.example.mvvmsampleapp.country


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetCountryUseCase
import javax.inject.Inject

class ViewModelFactory @Inject
constructor(private val useCase: GetCountryUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountryViewModel(useCase) as T
    }
}
