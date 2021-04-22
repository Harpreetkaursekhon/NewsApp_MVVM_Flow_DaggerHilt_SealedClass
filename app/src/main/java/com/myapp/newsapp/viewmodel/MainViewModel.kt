package com.myapp.newsapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.newsapp.model.Articles
import com.myapp.newsapp.model.News
import com.myapp.newsapp.network.utils.NewsData
import com.myapp.newsapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel(){

var _newsData: MutableStateFlow<NewsData> = MutableStateFlow(NewsData.Empty)
    private val newsData: StateFlow<NewsData> = _newsData

    fun getNewsData(){viewModelScope.launch {
        repository.getNewsData("tesla").onStart {
            _newsData.value= NewsData.Loading
        }.catch { e->

            _newsData.value= NewsData.Failure(e)
        }.collect { response->
            _newsData.value= NewsData.Success(response.articles)
        }
    }

    }

}