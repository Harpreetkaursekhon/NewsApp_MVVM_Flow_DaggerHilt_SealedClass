package com.myapp.newsapp.network.utils

import com.myapp.newsapp.model.Articles
import com.myapp.newsapp.model.News

sealed class NewsData {

    object Loading : NewsData()
    class Success(val data: List<Articles>):NewsData()
    class Failure(val msg:Throwable):NewsData()
    object Empty : NewsData()
}