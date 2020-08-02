package com.example.data.datasource

import androidx.lifecycle.LiveData
import com.example.domain.resultmapper.Result
import com.example.domain.resultmapper.ResultHandler
import com.example.mvvmsampleapp.database.CountryDao
import com.example.mvvmsampleapp.database.CountryEntity

class LocalDataSource(private var countryDao: CountryDao,private val responseHandler: ResultHandler)
{
    suspend fun getCountry(): Result<List<CountryEntity>> {
        return try {
            responseHandler.handleSuccess(countryDao.getCountries())
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    suspend fun getCountryCount(): Long = countryDao.getCountryCount()

    suspend fun insertCountries(countryList: List<CountryEntity>) = countryDao.insertAll(countryList)
}
