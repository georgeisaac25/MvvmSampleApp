package com.example.mvvmsampleapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {

    val APP_URL = "https://restcountries.eu/"

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder()
            .setUrl(APP_URL)
            .provideContext(this)
            .build()
    }
}