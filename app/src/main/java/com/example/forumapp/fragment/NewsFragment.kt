package com.example.forumapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forumapp.NewsUnit
import com.example.forumapp.R

class NewsFragment: Fragment() {
    private val newsList = ArrayList<NewsUnit>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_news, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewForNews)
        initNews()  // 添加新闻
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val adapter = NewsAdapter(newsList)
        recyclerView.adapter= adapter

        return view

    }

    private fun initNews() {
        repeat(2) {
            newsList.add(NewsUnit("Apple", R.drawable.test_1,"陈哥","2022-12-1"))
            newsList.add(NewsUnit("Banana", R.drawable.test_2,"丹爷","2022-1-1"))

        }
    }
}

//适配器
class NewsAdapter (val newsList: List<NewsUnit>):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val newsPicture:ImageView=view.findViewById(R.id.newsPicture)
        val newsTitle: TextView=view.findViewById(R.id.newsTitle)
        val newsTime: TextView = view.findViewById(R.id.newsTime)
        val newsAuthor:TextView = view.findViewById(R.id.newsAuthor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news_layout,parent,false)
//        val viewHolder=ViewHolder(view)
//        viewHolder.itemView.setOnClickListener{
//            val position=viewHolder.adapterPosition
//            val operator=opList[position]
//            Toast.makeText(parent.context,"功能：${operator.text}", Toast.LENGTH_SHORT).show()
//        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val operator=newsList[position]
        holder.newsPicture.setImageResource(operator.imageId)
        holder.newsTitle.text=operator.title
        holder.newsTime.text = operator.time
        holder.newsAuthor.text = operator.author
    }

    override fun getItemCount(): Int =newsList.size
}