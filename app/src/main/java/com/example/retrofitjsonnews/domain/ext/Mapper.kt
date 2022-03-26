package com.example.retrofitjsonnews.domain.ext

import com.example.retrofitjsonnews.data.model.NewsResponse
import com.example.retrofitjsonnews.domain.model.BaseItem
import com.example.retrofitjsonnews.domain.model.Date
import com.example.retrofitjsonnews.domain.model.News
import com.example.retrofitjsonnews.domain.model.NewsWrapper

fun NewsResponse.toNewsWrapper(): NewsWrapper {

    val items = mutableListOf<BaseItem>()
    val pattern = "dd.MM.yyyy"

    this.articles.forEachIndexed { index, item ->


        if (item.title != null && item.description != null && item.previewUrl != null) {

            when {
                index == 0 ->
                    items.add(Date(item.publishedAt?.toDate(pattern)))

                item.publishedAt?.toDate(pattern) != articles[index - 1].publishedAt?.toDate(pattern) ->
                    items.add(Date(item.publishedAt?.toDate(pattern)))
            }

            items.add(
                News(
                    title = item.title,
                    author = item.author,
                    description = item.description,
                    articleUrl = item.articleUrl,
                    previewUrl = item.previewUrl
                )
            )
        }
    }
    val count = resultsNumber.toString()

    return NewsWrapper(count, items)
}