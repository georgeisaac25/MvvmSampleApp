package com.example.mvvmsampleapp

import android.app.Application
import android.content.Context
import com.example.mvvmsampleapp.di.ActivityContributorModule
import com.example.mvvmsampleapp.di.CountryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(modules = [AndroidSupportInjectionModule::class, ActivityContributorModule::class,
        CountryModule::class])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder{
        fun build() : ApplicationComponent

        @BindsInstance
        fun setUrl(url:String) : Builder

        @BindsInstance
        fun provideContext(context: Context) : Builder
    }

}


