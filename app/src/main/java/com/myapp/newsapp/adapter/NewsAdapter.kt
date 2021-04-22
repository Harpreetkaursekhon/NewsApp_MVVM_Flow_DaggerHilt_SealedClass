package com.myapp.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myapp.newsapp.R
import com.myapp.newsapp.model.Articles
import com.myapp.newsapp.model.News

class NewsAdapter(var context: Context, var newsList:List<Articles>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article=  newsList[position]
        holder.title.text= article.title
        holder.description.text= article.description
        holder.author.text= article.author
        Glide.with(context)
            .load(article.urlToImage)
            .into(holder.newsImage)
    }

    override fun getItemCount(): Int = newsList.size

    class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var newsImage: ImageView =itemView.findViewById(R.id.newsImage)
       var title: TextView =itemView.findViewById(R.id.title)
        var description: TextView =itemView.findViewById(R.id.description)
        var author:TextView= itemView.findViewById(R.id.author)
    }

    fun setNewsData(newsList:List<Articles>)
    {
        this.newsList= newsList
        notifyDataSetChanged()
    }
}

