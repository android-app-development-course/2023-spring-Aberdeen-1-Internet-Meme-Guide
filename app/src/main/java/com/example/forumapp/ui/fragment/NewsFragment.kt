package com.example.forumapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forumapp.ArticleActivity
import com.example.forumapp.R
import com.example.forumapp.models.NewsUnit
import com.example.forumapp.ui.viewmodels.NewsViewModel

class NewsFragment: Fragment() {
//    private val newsList = ArrayList<NewsUnit>()
    private lateinit var newsViewModel:NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_news, container, false)
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewForNews)
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager    // 布局管理器
//        val adapter = NewsAdapter(newsList)
        val adapter = NewsAdapter(newsViewModel.newsList)
        adapter.onItemClick = { v, position ->    // 点击事件
            val newsUnit = newsViewModel.newsList[position]
            val intent = Intent(activity, ArticleActivity::class.java).apply {
                putExtra("type","news")
                putExtra("obj",newsUnit)
            }
            startActivity(intent)
        }
        recyclerView.adapter= adapter


        return view

    }


}

//适配器
class NewsAdapter (val newsList: List<NewsUnit>):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    lateinit var onItemClick: (view: View, position: Int) -> Unit

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val newsPicture:ImageView=view.findViewById(R.id.newsPicture)
        val newsTitle: TextView=view.findViewById(R.id.newsTitle)
        val newsTime: TextView = view.findViewById(R.id.newsTime)
        val newsAuthor:TextView = view.findViewById(R.id.newsAuthor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val operator=newsList[position]
        holder.newsPicture.setImageResource(operator.imageId)
        holder.newsTitle.text=operator.title
        holder.newsTime.text = operator.time
        holder.newsAuthor.text = operator.author

        holder.itemView.setOnClickListener{
            onItemClick.invoke(it, position)
        }
    }

    override fun getItemCount(): Int =newsList.size
}