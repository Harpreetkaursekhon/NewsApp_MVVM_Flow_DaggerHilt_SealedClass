package com.myapp.newsapp.model

//c6b6e325ab384b0ba829faee902954e5
//https://newsapi.org/v2/everything
//?q=tesla&from=2021-03-20&sortBy=publishedAt&apiKey=c6b6e325ab384b0ba829faee902954e5

data class News(val articles:List<Articles> )

data class Articles( val author:String, val title:String,val description:String,
                         val urlToImage:String)
