package com.example.retrofitjsonnews.domain

import com.example.retrofitjsonnews.domain.model.BaseItem
import com.example.retrofitjsonnews.domain.model.NewsAndCount

class NewsInteractorImpl(private val repository: NewsRepository) : NewsInteractor {
    override suspend fun getNews(searchWord: String): NewsAndCount {
        return repository.getNews(searchWord).toNewsAndCount()
    }
}