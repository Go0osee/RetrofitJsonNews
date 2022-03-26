package com.example.retrofitjsonnews.data

import com.example.retrofitjsonnews.data.model.NewsResponse
import com.example.retrofitjsonnews.domain.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepositoryImpl(val api: NewsApi) : NewsRepository {

    override suspend fun getNews(searchWord: String): NewsResponse {
        return withContext(Dispatchers.IO) {
            return@withContext api.getEverything(
                query = searchWord,
                language = "ru"
            )
        }
    }
}