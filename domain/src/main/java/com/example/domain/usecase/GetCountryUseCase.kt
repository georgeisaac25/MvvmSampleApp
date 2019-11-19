package com.example.domain.usecase

import com.example.domain.contract.RepositoryContract
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.responsemapper.Resource

class GetCountryUseCase(val repositoryContract: RepositoryContract) {
    suspend fun getCountry(): Resource<List<CountryUseCaseModel>> {
        return repositoryContract.getCountry()
    }
}