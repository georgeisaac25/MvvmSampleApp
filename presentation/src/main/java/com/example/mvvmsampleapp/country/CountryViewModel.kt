package com.example.mvvmsampleapp.country

import androidx.lifecycle.liveData
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.resultmapper.Result
import com.example.domain.usecase.GetCountryUseCase
import com.example.mvvmsampleapp.base.BaseViewModel
import com.example.mvvmsampleapp.mapper.MapperForDomainAndPresenter

class CountryViewModel(
    val useCase: GetCountryUseCase,
    val mapper: MapperForDomainAndPresenter<CountryUiModel, CountryUseCaseModel>
) : BaseViewModel() {

    var countryData = liveData {
        emit(Result.loading(null))
        val user = mapper.getPresenterModel(useCase.getCountry())
        emit(user)
    }
}