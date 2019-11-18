package com.example.mvvmsampleapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {
    @Query("SELECT * FROM countryTable")
    fun getAll(): List<CountryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(list: List<CountryEntity>): List<Long>

    @Query("SELECT * FROM countryTable WHERE name = :name")
    fun getIfExist(name: String): List<CountryEntity>
}
