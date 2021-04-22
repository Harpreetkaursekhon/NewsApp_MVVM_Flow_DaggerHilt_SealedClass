package com.myapp.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.littlemango.stacklayoutmanager.StackLayoutManager
import com.myapp.newsapp.adapter.NewsAdapter
import com.myapp.newsapp.model.Articles
import com.myapp.newsapp.network.utils.NewsData
import com.myapp.newsapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerview: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpUi()

        mainViewModel.getNewsData()
        lifecycleScope.launchWhenStarted {
            mainViewModel._newsData.collect {
                when (it) {
                    is NewsData.Loading -> {
                        recyclerview.isVisible = false
                        progress_bar.isVisible = true
                    }
                    is NewsData.Failure -> {
                        recyclerview.isVisible = false
                        progress_bar.isVisible = false
                        Log.d("main", "onCreate: ${it.msg}")
                    }
                    is NewsData.Success -> {
                        recyclerview.isVisible = true
                        progress_bar.isVisible = false
                        newsAdapter.setNewsData(it.data)

                    }
                    is NewsData.Empty -> {
                    }
                }
            }
        }
    }

    private fun setUpUi() {
        recyclerview = findViewById(R.id.recyclerview)
        newsAdapter = NewsAdapter(this, ArrayList<Articles>())
        recyclerview.apply {
            setHasFixedSize(true)
               layoutManager=LinearLayoutManager(this@MainActivity)
            adapter = newsAdapter


            }
        }
    }
