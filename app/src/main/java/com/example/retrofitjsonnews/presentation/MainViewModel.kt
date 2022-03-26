package com.example.retrofitjsonnews.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitjsonnews.domain.NewsInteractor
import com.example.retrofitjsonnews.domain.model.BaseItem
import com.example.retrofitjsonnews.domain.model.NewsAndCount
import kotlinx.coroutines.launch

class MainViewModel(private val newsInteractor: NewsInteractor) : ViewModel() {
    private val _news = MutableLiveData<NewsAndCount>()
    val news: LiveData<NewsAndCount> get() = _news

    fun searchNews(searchWord: String) {
        loadNews(searchWord)
    }

    private fun loadNews(searchWord: String) {
        viewModelScope.launch {
            _news.postValue(newsInteractor.getNews(searchWord))
        }
    }
}