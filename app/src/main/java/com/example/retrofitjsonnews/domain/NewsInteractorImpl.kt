package com.example.retrofitjsonnews.domain

import com.example.retrofitjsonnews.domain.ext.toNewsWrapper
import com.example.retrofitjsonnews.domain.model.NewsWrapper

class NewsInteractorImpl(private val repository: NewsRepository) : NewsInteractor {
    override suspend fun getNews(searchWord: String): NewsWrapper {
        return repository.getNews(searchWord).toNewsWrapper()
    }
}