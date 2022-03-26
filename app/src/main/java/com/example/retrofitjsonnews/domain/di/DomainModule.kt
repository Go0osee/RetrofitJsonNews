package com.example.retrofitjsonnews.domain.di

import com.example.retrofitjsonnews.data.NewsRepositoryImpl
import com.example.retrofitjsonnews.data.RetrofitClient
import com.example.retrofitjsonnews.domain.NewsInteractor
import com.example.retrofitjsonnews.domain.NewsInteractorImpl
import com.example.retrofitjsonnews.domain.NewsRepository
import org.koin.dsl.module

val modelModule = module {
    single<NewsInteractor> {
        NewsInteractorImpl(
            get()
        )
    }

    single<NewsRepository> {
        NewsRepositoryImpl(
            RetrofitClient.getNewsApi()
        )
    }
}