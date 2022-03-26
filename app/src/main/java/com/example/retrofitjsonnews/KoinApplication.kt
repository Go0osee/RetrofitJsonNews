package com.example.retrofitjsonnews

import android.app.Application
import com.example.retrofitjsonnews.data.di.dataModule
import com.example.retrofitjsonnews.domain.di.modelModule
import com.example.retrofitjsonnews.presentation.di.viewModelModule
import org.koin.core.context.startKoin

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    viewModelModule,
                    modelModule,
                    dataModule
                )
            )
        }
    }
}