package com.example.mvvmsampleapp.di

import android.content.Context
import com.example.mvvmsampleapp.ApplicationScope
import com.example.mvvmsampleapp.ContextModule
import com.example.mvvmsampleapp.util.Utilities
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class UtilitiesModule {
    @ApplicationScope
    @Provides
    fun getUtilities(context: Context?): Utilities {
        return Utilities(context!!)
    }
}