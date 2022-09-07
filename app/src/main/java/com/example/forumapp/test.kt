package com.example.forumapp

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class test : AppCompatActivity() {
    private val newsList = ArrayList<NewsUnit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)
        initNews() // 初始化新闻数据
        val adapter = NewsAdapter(this, R.layout.news_short_layout, newsList)
        val listView = findViewById<ListView>(R.id.test)
        listView.adapter = adapter
    }

    private fun initNews() {
        repeat(2) {
            newsList.add(NewsUnit("Apple", R.drawable.test_1,"chenge","2022-12-1"))
            newsList.add(NewsUnit("Banana", R.drawable.test_2,"danye","2022-1-1"))

        }
    }
}