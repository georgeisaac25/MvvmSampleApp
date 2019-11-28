package com.example.mvvmsampleapp

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ContextModule {
    @ApplicationScope
    @Provides
    @Named("APP_CONTEXT")
    fun provideContext(context: Context): Context  = context
}
