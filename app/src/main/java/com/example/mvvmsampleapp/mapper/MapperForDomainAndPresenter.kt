package com.example.mvvmsampleapp.mapper

import com.example.domain.responsemapper.Resource

interface MapperForDomainAndPresenter<T,N> {
    fun getUseCaseModel(n: Resource<List<T>>) : Resource<List<N>>
    fun getPresenterModel(t: Resource<List<N>>) : Resource<List<T>>
}