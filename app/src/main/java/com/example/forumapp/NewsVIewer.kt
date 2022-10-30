package com.example.forumapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsUnit(val title:String,val imageId:Int, val author:String, val time:String)

class NewsAdapter(val newsList: List<NewsUnit>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val newsImage: ImageView = view.findViewById(R.id.newsPicture)
        val newsTitle: TextView = view.findViewById(R.id.newsTitle)
        val newsTime: TextView = view.findViewById(R.id.newsTime)
        val newsAuthor: TextView = view.findViewById(R.id.newsAuthor)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news_layout, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newsList[position]
        holder.newsImage.setImageResource(news.imageId)
        holder.newsTitle.text = news.title
        holder.newsTime.text = news.time
        holder.newsAuthor.text = news.author
    }
    override fun getItemCount() = newsList.size
}

