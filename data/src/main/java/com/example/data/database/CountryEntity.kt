package com.example.mvvmsampleapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "countryTable", indices = arrayOf(Index(value = ["name"], unique = true)))
class CountryEntity(){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "did")
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "alpha2Code")
    var alpha2Code: String? = null

    @ColumnInfo(name = "alpha3Code")
    var alpha3Code: String? = null

    @ColumnInfo(name = "flag")
    var flag: String? = null

}