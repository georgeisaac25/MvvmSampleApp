package com.example.mvvmsampleapp.country

import android.util.Log
import androidx.lifecycle.liveData
import com.example.data.remote.retrofit.responseForCountry.Country
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.responsemapper.Resource
import com.example.domain.usecase.GetCountryUseCase
import com.example.mvvmsampleapp.base.BaseViewModel
import com.example.mvvmsampleapp.mapper.MapperForDomainAndPresenter
import kotlinx.coroutines.Dispatchers

class CountryViewModel(
    val useCase: GetCountryUseCase,
    val mapper: MapperForDomainAndPresenter<CountryUiModel, CountryUseCaseModel>
) : BaseViewModel() {

    var countryData = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val user = mapper.getPresenterModel(useCase.getCountry())
        emit(user)
    }
}