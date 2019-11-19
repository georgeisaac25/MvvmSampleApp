package com.example.data.datasource

import com.example.data.mapper.MapperForDomainAndDataImpl
import com.example.data.remote.retrofit.responseForCountry.Country
import com.example.domain.contract.RepositoryContract
import com.example.domain.mapper.MapperForDomainAndData
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.responsemapper.Resource


class DataRepository(
    val localDataSource: LocalDataSource, val remoteDataSource: RemoteDataSource
    , val mapper: MapperForDomainAndData<Country, CountryUseCaseModel>
) :
    RepositoryContract {

    override suspend fun getCountry(): Resource<List<CountryUseCaseModel>> {
        val result: Resource<List<Country>> = remoteDataSource.getCountry()
        return mapper.getUseCaseModel(result)
    }
}