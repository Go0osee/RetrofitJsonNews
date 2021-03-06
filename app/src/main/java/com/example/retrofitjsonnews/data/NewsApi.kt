package com.example.retrofitjsonnews.data

import com.example.retrofitjsonnews.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    /**
     * Search through millions of articles from over 50,000 large and small news sources and blogs.
     * This includes breaking news as well as lesser articles.
     * This endpoint suits article discovery and analysis,
     * but can be used to retrieve articles for display, too.
     *
     * @param query
     * Keywords or a phrase to search for
     *
     * @param fromDate A date and optional time for the oldest article allowed.
     * This should be in ISO 8601 format (e.g. 2020-07-20 or 2020-07-20T06:24:14)
     * Default: the oldest according to your plan.
     *
     * @param toDate A date and optional time for the newest article allowed.
     * This should be in ISO 8601 format (e.g. 2020-07-20 or 2020-07-20T06:24:14)
     * Default: the newest according to your plan.
     *
     * @param language The 2-letter ISO-639-1 code of the language you want to get headlines for.
     * Possible options: ar de en es fr he it nl no pt ru se ud zh.
     * Default: all languages returned.
     *
     * @param sortBy The order to sort the articles in.
     * Possible options:
     * relevancy, popularity, publishedAt.
     * relevancy = articles more closely related to q come first.
     * popularity = articles from popular sources and publishers come first.
     * publishedAt = newest articles come first.
     * Default: publishedAt
     *
     * @param pageNumber - Use this to page through the results.
     *
     * @param pageSize - The number of results to return per page. 20 is the default, 100 is the maximum.
     */

    @GET("everything")
    suspend fun getEverything(
        @Query("q") query: String?,
        @Query("language") language: String?,
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("page") pageNumber: Int = 1,
     //   @Query("sources") sources: String = "RBC",
        @Query("pageSize") pageSize: Int = 20,
        @Query("apiKey") apiKey: String = RetrofitClient.BASE_API_KEY
    ): NewsResponse
}