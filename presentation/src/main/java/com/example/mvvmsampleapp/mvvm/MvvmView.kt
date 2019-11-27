package com.example.mvvmsampleapp.mvvm

interface MvvmView<T> {
    fun getViewModelInstance() : T
    fun observeData(viewModel : T)
}