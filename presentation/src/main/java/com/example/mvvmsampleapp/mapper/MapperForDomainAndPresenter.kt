package com.example.mvvmsampleapp.mapper

import com.example.domain.resultmapper.Result

interface MapperForDomainAndPresenter<T,N> {
    fun getUseCaseModel(n: Result<List<T>>) : Result<List<N>>
    fun getPresenterModel(t: Result<List<N>>) : Result<List<T>>
}