package com.example.forumapp.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forumapp.NewsUnit
import com.example.forumapp.R

class PostFragment: Fragment() {
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
            newsList.add(NewsUnit("Banana", R.drawable.test_2,"丹爷","2022-1-1"))
            newsList.add(NewsUnit("Apple", R.drawable.test_1,"陈哥","2022-12-1"))


        }
    }
}

//适配器
