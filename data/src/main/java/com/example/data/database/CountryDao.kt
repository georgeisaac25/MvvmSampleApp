package com.example.mvvmsampleapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {
    @Query("SELECT * FROM countryTable")
    suspend fun getCountries(): List<CountryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<CountryEntity>?): List<Long>

    @Query("SELECT * FROM countryTable WHERE name = :name")
    fun getIfExist(name: String): LiveData<List<CountryEntity>>

    @Query("SELECT COUNT(name) FROM countryTable")
    suspend fun getCountryCount(): Long
}
