package com.example.retrofitjsonnews.data.di

import com.example.retrofitjsonnews.data.RetrofitClient
import org.koin.dsl.module

val dataModule = module {
    single {
        RetrofitClient.getNewsApi()
    }
}