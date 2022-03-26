package com.example.retrofitjsonnews.domain

import com.example.retrofitjsonnews.data.model.NewsResponse
import com.example.retrofitjsonnews.domain.model.BaseItem
import com.example.retrofitjsonnews.domain.model.Date
import com.example.retrofitjsonnews.domain.model.News
import com.example.retrofitjsonnews.domain.model.NewsWrapper
import java.text.SimpleDateFormat

fun NewsResponse.toNewsAndCount(): NewsWrapper {

    val items = mutableListOf<BaseItem>()

    this.articles.forEachIndexed { index, item ->

        when {
            index == 0 ->
                items.add(Date(item.publishedAt.toDate()))
            item.publishedAt.toDate() != articles[index - 1].publishedAt.toDate() ->
                items.add(Date(item.publishedAt.toDate()))
            item.previewUrl != null ->
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

fun String.toDate(): String =
    SimpleDateFormat("dd.MM.yyyy")
        .format(SimpleDateFormat("yyyy-MM-dd")
                .parse(this.substring(0, 10)))
