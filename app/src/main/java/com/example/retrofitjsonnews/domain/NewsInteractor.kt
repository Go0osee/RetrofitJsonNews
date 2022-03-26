package com.example.retrofitjsonnews.domain

import com.example.retrofitjsonnews.domain.model.BaseItem
import com.example.retrofitjsonnews.domain.model.NewsAndCount

interface NewsInteractor {
    suspend fun getNews(searchWord: String): NewsAndCount
}