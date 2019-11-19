package com.example.mvvmsampleapp.di

import com.example.mvvmsampleapp.country.CountryAdapter
import dagger.Module
import dagger.Provides

@Module
class CountryAdapterModule {

    @CountryScope
    @Provides
    fun provideAdapter() : CountryAdapter = CountryAdapter()
}