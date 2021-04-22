package com.myapp.newsapp.network

import com.myapp.newsapp.model.Articles
import com.myapp.newsapp.model.News
import javax.inject.Inject

class ApiServiceImp @Inject constructor(private val apiService: ApiService) {

    suspend fun getNewsData(q:String, apiKey:String):News = apiService.getNewsData(q, apiKey)
}