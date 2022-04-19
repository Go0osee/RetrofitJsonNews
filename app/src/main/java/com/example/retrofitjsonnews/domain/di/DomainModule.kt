package com.example.retrofitjsonnews.domain.di

import com.example.retrofitjsonnews.data.NewsApi
import com.example.retrofitjsonnews.data.NewsRepositoryImpl
import com.example.retrofitjsonnews.domain.NewsInteractor
import com.example.retrofitjsonnews.domain.NewsInteractorImpl
import com.example.retrofitjsonnews.domain.NewsRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideNewsInteractor(
        repository: NewsRepository
    ): NewsInteractor {
        return NewsInteractorImpl(repository)
    }

    @Provides
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }
}