package com.myapp.newsapp.repository

import com.myapp.newsapp.model.Articles
import com.myapp.newsapp.model.News
import com.myapp.newsapp.network.ApiServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor (private val apiServiceImp: ApiServiceImp) {


    fun getNewsData(q:String): Flow<News> = flow {
        emit(apiServiceImp.getNewsData(q,"c6b6e325ab384b0ba829faee902954e5" ))
    }.flowOn(Dispatchers.IO)

}


