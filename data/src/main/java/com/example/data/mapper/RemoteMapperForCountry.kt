package com.example.data.mapper

import com.example.data.remote.retrofit.responseForCountry.Country
import com.example.domain.mapper.MapperForDomainAndData
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.resultmapper.Result
import com.example.domain.resultmapper.Status

class RemoteMapperForCountry : MapperForDomainAndData<Country, CountryUseCaseModel> {
    override fun getUseCaseModel(n: Result<List<Country>>): Result<List<CountryUseCaseModel>> {
        var list: ArrayList<CountryUseCaseModel>? = ArrayList<CountryUseCaseModel>()

        if (n.status == Status.SUCCESS) {
            for (i in n.data!!) {
                list?.add(CountryUseCaseModel(i.id, i.name, i.alpha2Code, i.alpha3Code, i.flag))
            }
        } else {
            list = null
        }
        return Result<List<CountryUseCaseModel>>(n.status, list, n.message)
    }

    override fun getDataModel(t: Result<List<CountryUseCaseModel>>): Result<List<Country>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}