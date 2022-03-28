package com.example.retrofitjsonnews.domain.ext

import java.text.SimpleDateFormat

fun String.toDate(pattern: String): String =
    SimpleDateFormat("dd.MM.yyyy")
        .format(SimpleDateFormat("yyyy-MM-dd")
            .parse(this))