package com.example.retrofitjsonnews.domain

import com.example.retrofitjsonnews.data.model.NewsResponse
import com.example.retrofitjsonnews.domain.model.BaseItem
import com.example.retrofitjsonnews.domain.model.Date
import com.example.retrofitjsonnews.domain.model.News
import com.example.retrofitjsonnews.domain.model.NewsAndCount


fun NewsResponse.toNewsAndCount(): NewsAndCount {

    val items = mutableListOf<BaseItem>()

    this.articles.forEachIndexed { index, item ->
        if (index == 0) {
            items.add(Date(item.publishedAt.toDate()))
        } else if (item.publishedAt.toDate() != this.articles[index - 1].publishedAt.toDate()) {
            items.add(Date(item.publishedAt.toDate()))
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
    val count = this.resultsNumber.toString()

    return NewsAndCount(count, items)
}

fun String.toDate(): String {
    return this.substring(0, 10)
}