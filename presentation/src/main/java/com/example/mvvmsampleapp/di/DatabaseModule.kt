package com.example.mvvmsampleapp

import android.content.Context
import androidx.room.Room
import com.example.mvvmsampleapp.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class DatabaseModule {
    private val DB_NAME = "countryDatabase.db"

    @ApplicationScope
    @Provides
    internal fun provideDb(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DB_NAME
        ).build();
    }
}