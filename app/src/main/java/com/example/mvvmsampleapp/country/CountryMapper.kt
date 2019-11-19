package com.example.mvvmsampleapp.country

import com.example.domain.model.CountryUseCaseModel
import com.example.domain.responsemapper.Resource
import com.example.mvvmsampleapp.mapper.MapperForDomainAndPresenter

class CountryMapper : MapperForDomainAndPresenter<CountryUiModel, CountryUseCaseModel> {
    override fun getUseCaseModel(n: Resource<List<CountryUiModel>>): Resource<List<CountryUseCaseModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPresenterModel(t: Resource<List<CountryUseCaseModel>>): Resource<List<CountryUiModel>> {
        var list: ArrayList<CountryUiModel>? = ArrayList()
        for (i in t.data!!) {
            list?.add(CountryUiModel(i.id, i.name, i.alpha2Code, i.alpha3Code, i.flag))
        }
        return Resource<List<CountryUiModel>>(t.status, list, t.message)
    }
}