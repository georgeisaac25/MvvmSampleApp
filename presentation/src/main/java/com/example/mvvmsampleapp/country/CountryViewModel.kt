package com.example.mvvmsampleapp.country

import android.util.Log
import androidx.lifecycle.liveData
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.resultmapper.Result
import com.example.domain.usecase.GetCountryUseCase
import com.example.mvvmsampleapp.base.BaseViewModel
import com.example.mvvmsampleapp.mapper.MapperForDomainAndPresenter
import kotlinx.coroutines.delay

class CountryViewModel(
    val useCase: GetCountryUseCase,
    val mapper: MapperForDomainAndPresenter<CountryUiModel, CountryUseCaseModel>
) : BaseViewModel() {

    var countryData = liveData {
        Log.e("checking","rotation")
        delay(4000)
        emit(Result.loading(null))
        val user = mapper.getPresenterModel(useCase.getCountry())
        emit(user)
    }

    // NOTE : Must observe livedata variable and
    // not a method because VM only retains the variables

    /*fun getDetails() = liveData {
        Log.e("checking","rotation")
        delay(4000)
        emit(Result.loading(null))
        val user = mapper.getPresenterModel(useCase.getCountry())
        emit(user)
    }*/
}