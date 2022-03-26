package com.example.retrofitjsonnews.domain.model

import com.google.gson.annotations.SerializedName

class News(
    val author: String?,
    val title: String?,
    val description: String?,
    val articleUrl: String?,
    val previewUrl: String?
): BaseItem()