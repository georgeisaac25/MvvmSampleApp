package com.example.data.mapper

import com.example.data.remote.retrofit.responseForCountry.Country
import com.example.domain.mapper.MapperForDomainAndData
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.responsemapper.Resource
import com.example.mvvmsampleapp.database.CountryEntity

class LocalMapperForDomainAndDataImpl : MapperForDomainAndData<CountryEntity, CountryUseCaseModel>{

    override fun getUseCaseModel(n: Resource<List<CountryEntity>>): Resource<List<CountryUseCaseModel>> {
        val list : ArrayList<CountryUseCaseModel>? = ArrayList<CountryUseCaseModel>()
        for (i in n.data!!){
            list?.add(CountryUseCaseModel(i.id,i.name,i.alpha2Code,i.alpha3Code,i.flag))
        }
        return Resource<List<CountryUseCaseModel>>(n.status,list,n.message)
    }

    override fun getDataModel(t: Resource<List<CountryUseCaseModel>>): Resource<List<CountryEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}