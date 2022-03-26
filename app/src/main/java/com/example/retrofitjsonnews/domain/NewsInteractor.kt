package com.example.retrofitjsonnews.domain

import com.example.retrofitjsonnews.domain.model.NewsWrapper

interface NewsInteractor {
    suspend fun getNews(searchWord: String): NewsWrapper
}