package com.example.retrofitjsonnews.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitjsonnews.domain.NewsInteractor
import com.example.retrofitjsonnews.domain.model.NewsWrapper
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val newsInteractor: NewsInteractor) : ViewModel() {
    private val _news = MutableLiveData<NewsWrapper>()
    val news: LiveData<NewsWrapper> get() = _news

    fun searchNews(searchWord: String) {
        loadNews(searchWord)
    }

    private fun loadNews(searchWord: String) {
        viewModelScope.launch {
            _news.postValue(newsInteractor.getNews(searchWord))
        }
    }
}