package com.myapp.newsapp.di

import com.myapp.newsapp.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun baseUrl()= "https://newsapi.org/"

    @Provides
    @Singleton
    fun retrofitBuilder(url:String)=
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()!!

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit)=
        retrofit.create(ApiService::class.java)!!
}