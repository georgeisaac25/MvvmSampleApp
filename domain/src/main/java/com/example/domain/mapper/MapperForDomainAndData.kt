package com.example.domain.mapper

import com.example.domain.resultmapper.Result

interface MapperForDomainAndData<T, N> {
    fun getUseCaseModel(n: Result<List<T>>): Result<List<N>>
    fun getDataModel(t: Result<List<N>>): Result<List<T>>
}