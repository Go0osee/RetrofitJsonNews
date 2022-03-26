package com.example.retrofitjsonnews.domain

import com.example.retrofitjsonnews.data.NewsRepositoryImpl
import com.example.retrofitjsonnews.data.RetrofitClient
import com.example.retrofitjsonnews.data.model.NewsResponse

interface NewsRepository {
    suspend fun getNews(searchWord: String): NewsResponse
}

fun getRepository(): NewsRepository = NewsRepositoryImpl(
    api = RetrofitClient.getNewsApi()
)