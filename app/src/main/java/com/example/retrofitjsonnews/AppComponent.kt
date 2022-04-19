package com.example.retrofitjsonnews

import android.content.Context
import com.example.retrofitjsonnews.data.di.DataModule
import com.example.retrofitjsonnews.domain.di.DomainModule
import com.example.retrofitjsonnews.presentation.MainActivity
import com.example.retrofitjsonnews.presentation.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [DataModule::class, DomainModule::class, ViewModelModule::class]
)
interface AppComponent {
    fun inject(target: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun buildContext(context: Context): Builder

        fun build(): AppComponent
    }
}