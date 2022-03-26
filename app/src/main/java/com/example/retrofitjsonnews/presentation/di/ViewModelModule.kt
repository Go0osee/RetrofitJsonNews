package com.example.retrofitjsonnews.presentation.di

import com.example.retrofitjsonnews.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel() {
        MainViewModel(
            get()
        )
    }
}