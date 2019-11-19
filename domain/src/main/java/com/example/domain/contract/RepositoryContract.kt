package com.example.domain.contract

import com.example.domain.model.CountryUseCaseModel
import com.example.domain.responsemapper.Resource

interface RepositoryContract {
    suspend fun getCountry(): Resource<List<CountryUseCaseModel>>
}
