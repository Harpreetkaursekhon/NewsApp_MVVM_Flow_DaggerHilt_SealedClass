package com.myapp.newsapp.network

import com.myapp.newsapp.model.Articles
import com.myapp.newsapp.model.News
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/everything")
    suspend fun getNewsData(
        @Query("q")q:String,
        @Query("apiKey")apiKey:String
    ):News
}