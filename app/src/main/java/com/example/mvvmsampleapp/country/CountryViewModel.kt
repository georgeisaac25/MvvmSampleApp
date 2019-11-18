package com.example.mvvmsampleapp.country

import android.util.Log
import androidx.lifecycle.liveData
import com.example.data.remote.retrofit.responseForCountry.Country
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.responsemapper.Resource
import com.example.domain.usecase.GetCountryUseCase
import com.example.mvvmsampleapp.base.BaseViewModel
import kotlinx.coroutines.Dispatchers

class CountryViewModel(val useCase: GetCountryUseCase) : BaseViewModel(){
    override fun observeData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var countryData = liveData(Dispatchers.IO) {
        Log.e("inside","corotine")
        val user = mapper(useCase.getCountry())
        emit(user)
    }

    fun mapper(resource : Resource<List<CountryUseCaseModel>>) : Resource<List<CountryUiModel>> {
        var list : ArrayList<CountryUiModel>? = ArrayList()
        for (i in resource.data!!){
            list?.add(CountryUiModel(i.id,i.name,i.alpha2Code,i.alpha3Code,i.flag))
        }
        return Resource<List<CountryUiModel>>(resource.status,list,resource.message)
    }


}