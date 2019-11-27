package com.example.mvvmsampleapp.base

import com.example.mvvmsampleapp.mvvm.MvvmView
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseView<T> : DaggerAppCompatActivity(), MvvmView<T>