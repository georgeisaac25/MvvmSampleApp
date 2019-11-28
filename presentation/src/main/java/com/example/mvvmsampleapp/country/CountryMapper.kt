package com.example.mvvmsampleapp.country

import com.example.domain.model.CountryUseCaseModel
import com.example.domain.resultmapper.Result
import com.example.domain.resultmapper.Status
import com.example.mvvmsampleapp.mapper.MapperForDomainAndPresenter

class CountryMapper : MapperForDomainAndPresenter<CountryUiModel, CountryUseCaseModel> {
    override fun getUseCaseModel(n: Result<List<CountryUiModel>>): Result<List<CountryUseCaseModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPresenterModel(t: Result<List<CountryUseCaseModel>>): Result<List<CountryUiModel>> {
        var list: ArrayList<CountryUiModel>? = ArrayList()


        if (t.status == Status.SUCCESS) {
            for (i in t.data!!) {
                list?.add(CountryUiModel(i.id, i.name, i.alpha2Code, i.alpha3Code, i.flag))
            }
        } else {
            list = null
        }
        return Result<List<CountryUiModel>>(t.status, list, t.message)
    }
}