package com.example.data.mapper

import com.example.domain.mapper.MapperForDomainAndData
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.resultmapper.Result
import com.example.mvvmsampleapp.database.CountryEntity

class LocalMapperForCountry : MapperForDomainAndData<CountryEntity, CountryUseCaseModel>{

    override fun getUseCaseModel(n: Result<List<CountryEntity>>): Result<List<CountryUseCaseModel>> {
        val list : ArrayList<CountryUseCaseModel>? = ArrayList()
        for (i in n.data!!){
            list?.add(CountryUseCaseModel(i.id,i.name,i.alpha2Code,i.alpha3Code,i.flag))
        }
        return Result<List<CountryUseCaseModel>>(n.status,list,n.message)
    }

    override fun getDataModel(t: Result<List<CountryUseCaseModel>>): Result<List<CountryEntity>> {
        val list : ArrayList<CountryEntity>? = ArrayList()
        for (i in t.data!!){
            list?.add(CountryEntity(i.id,i.name,i.alpha2Code,i.alpha3Code,i.flag))
        }
        return Result<List<CountryEntity>>(t.status,list,t.message)
    }
}