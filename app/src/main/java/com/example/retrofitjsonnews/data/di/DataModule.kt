package com.example.retrofitjsonnews.data.di

import com.example.retrofitjsonnews.data.NewsApi
import com.example.retrofitjsonnews.data.RetrofitClient
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideNewsApi(): NewsApi {
        return RetrofitClient.getNewsApi()
    }
}