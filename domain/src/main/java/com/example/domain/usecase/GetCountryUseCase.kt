package com.example.domain.usecase

import com.example.domain.contract.RepositoryContract
import com.example.domain.model.CountryUseCaseModel
import com.example.domain.resultmapper.Result

class GetCountryUseCase(val repositoryContract: RepositoryContract) {
    suspend fun getCountry(): Result<List<CountryUseCaseModel>> {
        return repositoryContract.getCountry()
    }
}