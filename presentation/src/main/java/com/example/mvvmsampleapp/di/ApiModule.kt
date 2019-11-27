package com.example.mvvmsampleapp

import com.example.data.remote.retrofit.ApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class ApiModule {

    @ApplicationScope
    @Provides
    fun getRetrofit(string: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(string)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @ApplicationScope
    @Provides
    @Named("URL")
    fun setUrl(url: String): String = url

    @ApplicationScope
    @Provides
    fun getApiService(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }


}