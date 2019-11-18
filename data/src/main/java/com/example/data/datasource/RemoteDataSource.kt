package com.example.data.datasource

import com.example.data.remote.retrofit.ApiInterface
import com.example.domain.responsemapper.ResponseHandler
import com.example.data.remote.retrofit.responseForCountry.Country
import com.example.domain.responsemapper.Resource

class RemoteDataSource(val apiInterface : ApiInterface,val responseHandler: ResponseHandler) {

    suspend fun getCountry() : Resource<List<Country>> {
        return try {
            responseHandler.handleSuccess(apiInterface.getCountries())
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}