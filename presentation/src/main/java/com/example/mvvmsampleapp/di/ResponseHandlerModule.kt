package com.example.mvvmsampleapp.di

import com.example.domain.responsemapper.ResponseHandler
import com.example.mvvmsampleapp.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ResponseHandlerModule {

    @ApplicationScope
    @Provides
    fun provideResponseHandler(): ResponseHandler = ResponseHandler()
}