package com.example.mvvmsampleapp.di

import com.example.domain.resultmapper.ResultHandler
import com.example.mvvmsampleapp.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ResponseHandlerModule {

    @ApplicationScope
    @Provides
    fun provideResponseHandler(): ResultHandler = ResultHandler()
}