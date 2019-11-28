package com.example.data.datasource

import com.example.data.remote.retrofit.ApiInterface
import com.example.data.remote.retrofit.responseForCountry.Country
import com.example.domain.resultmapper.Result
import com.example.domain.resultmapper.ResultHandler

class RemoteDataSource(private val apiInterface: ApiInterface, private val responseHandler: ResultHandler) {

    suspend fun getCountry(): Result<List<Country>> {
        return try {
            var country = apiInterface.getCountries()
            responseHandler.handleSuccess(country)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}