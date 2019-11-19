package com.example.domain.mapper

import com.example.domain.responsemapper.Resource

interface MapperForDomainAndData<T, N> {
    fun getUseCaseModel(n: Resource<List<T>>): Resource<List<N>>
    fun getDataModel(t: Resource<List<N>>): Resource<List<T>>
}