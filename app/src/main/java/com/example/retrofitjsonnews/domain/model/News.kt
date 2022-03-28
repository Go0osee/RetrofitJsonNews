package com.example.retrofitjsonnews.domain.model

class News(
    val author: String?,
    val title: String,
    val description: String,
    val articleUrl: String?,
    val previewUrl: String
) : BaseItem()