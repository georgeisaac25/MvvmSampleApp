package com.example.data.datasource

import android.util.Log
import com.example.data.remote.retrofit.responseForCountry.Country
import com.example.domain.contract.RepositoryContract
import com.example.domain.mapper.MapperForDomainAndData
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.resultmapper.Result
import com.example.domain.resultmapper.Status
import com.example.mvvmsampleapp.database.CountryEntity


class DataRepository(
    private val localDataSource: LocalDataSource,private val remoteDataSource: RemoteDataSource
    ,private val remoteMapper: MapperForDomainAndData<Country, CountryUseCaseModel>
    ,private val localMapper: MapperForDomainAndData<CountryEntity,CountryUseCaseModel>
) : RepositoryContract {



    override suspend fun getCountry(): Result<List<CountryUseCaseModel>> {
        return if(localDataSource.getCountryCount() > 0){
            val result: Result<List<CountryEntity>> = localDataSource.getCountry()
            localMapper.getUseCaseModel(result)
        } else{
            val result: Result<List<Country>> = remoteDataSource.getCountry()
            val countryUseCaseModel = remoteMapper.getUseCaseModel(result)
            if(countryUseCaseModel.data!=null && !countryUseCaseModel.data!!.isEmpty()){
                localDataSource.insertCountries(localMapper.getDataModel(countryUseCaseModel).data!!)
                Log.e("size",""+countryUseCaseModel.status)
            }
            return countryUseCaseModel
        }
    }
}