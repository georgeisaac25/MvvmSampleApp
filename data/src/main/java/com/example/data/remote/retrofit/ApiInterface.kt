package com.example.data.remote.retrofit

import com.example.data.remote.retrofit.responseForCountry.Country
import retrofit2.http.GET
import retrofit2.Call;

interface ApiInterface {
    @GET("rest/v2/all/")
    suspend fun  getCountries() : List<Country>
}