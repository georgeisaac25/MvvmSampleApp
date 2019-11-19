package com.example.data.mapper

import com.example.data.remote.retrofit.responseForCountry.Country
import com.example.domain.mapper.MapperForDomainAndData
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.responsemapper.Resource

class MapperForDomainAndDataImpl : MapperForDomainAndData<Country, CountryUseCaseModel>{
    override fun getUseCaseModel(n: Resource<List<Country>>): Resource<List<CountryUseCaseModel>> {
        var list : ArrayList<CountryUseCaseModel>? = ArrayList<CountryUseCaseModel>()
        for (i in n.data!!){
            list?.add(CountryUseCaseModel(i.id,i.name,i.alpha2Code,i.alpha3Code,i.flag))
        }
        return Resource<List<CountryUseCaseModel>>(n.status,list,n.message)
    }

    override fun getDataModel(t: Resource<List<CountryUseCaseModel>>): Resource<List<Country>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}