package com.example.domain.contract

import com.example.domain.model.CountryUseCaseModel
import com.example.domain.resultmapper.Result

interface RepositoryContract {
    suspend fun getCountry(): Result<List<CountryUseCaseModel>>
}
