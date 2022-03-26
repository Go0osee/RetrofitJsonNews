package com.example.retrofitjsonnews.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URl = "https://newsapi.org/v2/"
    const val BASE_API_KEY = "e7c11afc6fa24f83b812aa976816e645"

    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private fun getClient() = Retrofit.Builder()
        .baseUrl(BASE_URl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getNewsApi(): NewsApi = getClient().create(NewsApi::class.java)
}