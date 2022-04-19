package com.example.retrofitjsonnews.presentation.di

import com.example.retrofitjsonnews.domain.NewsInteractor
import com.example.retrofitjsonnews.presentation.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideMainViewModel(
        interactor: NewsInteractor
    ): MainViewModel{
        return MainViewModel(interactor)
    }
}