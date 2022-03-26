package com.example.retrofitjsonnews.domain

import com.example.retrofitjsonnews.data.model.NewsResponse

interface NewsRepository {
    suspend fun getNews(searchWord: String): NewsResponse
}

