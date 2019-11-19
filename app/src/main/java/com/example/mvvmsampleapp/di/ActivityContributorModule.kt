package com.example.mvvmsampleapp.di

import com.example.mvvmsampleapp.country.CountryActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityContributorModule {

    @CountryScope
    @ContributesAndroidInjector(modules = [CountryModule::class])
    internal abstract fun contributeFirstActivity(): CountryActivity
}
