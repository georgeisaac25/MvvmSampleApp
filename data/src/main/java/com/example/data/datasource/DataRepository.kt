package com.example.data.datasource

import com.example.data.remote.retrofit.responseForCountry.Country
import com.example.domain.contract.RepositoryContract
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.responsemapper.Resource


class DataRepository(val localDataSource: LocalDataSource, val remoteDataSource: RemoteDataSource) :
    RepositoryContract {

    override suspend fun getCountry() : Resource<List<CountryUseCaseModel>> {
         var result = remoteDataSource.getCountry()
        return mapper(result)

    }

    fun mapper(resource : Resource<List<Country>>) : Resource<List<CountryUseCaseModel>>{
        var list : ArrayList<CountryUseCaseModel>? = ArrayList<CountryUseCaseModel>()
        for (i in resource.data!!){
           list?.add(CountryUseCaseModel(i.id,i.name,i.alpha2Code,i.alpha3Code,i.flag))
        }
        return Resource<List<CountryUseCaseModel>>(resource.status,list,resource.message)
    }
}