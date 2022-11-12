package com.example.forumapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forumapp.R
import com.example.forumapp.models.NewsUnit

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
        recyclerView.layoutManager = layoutManager    // 布局管理器
        val adapter = NewsAdapter(newsList)
        adapter.onItemClick = { v, position ->    // 点击事件
            val newsUnit = newsList[position]
            val intent = Intent(activity, ArticleActivity::class.java).apply {
                putExtra("type","news")
                putExtra("obj",newsUnit)
            }
            startActivity(intent)
        }
        recyclerView.adapter= adapter


        return view

    }

    private fun initNews() {
        repeat(2) {
            newsList.add(NewsUnit("Apple", R.drawable.test_1,"陈哥",
                "2022-12-1","<!DOCTYPE html>" +
                        "<html>" +
                        "    <head>" +
                        "        <meta charset=\"utf-8\">" +
                        "        <title>主页 - Eason_R</title>" +
                        "        <meta name=\"creater\" content=\"Eason_R\">" +
                        "    </head>" +
                        "    <body>" +
                        "        <h1>欢迎来到主页1</h1>" +
                        "        <p>点击下列链接即可跳转</p>" +
                        "        <ul>" +
                        "            <li>主页</li>" +
                        "            <li>跳转测试 - <a href=\"\">论坛</a></li>" +
                        "            <li><a href=\"\">gangsters</a></li>" +
                        "            <li><a href=\"\">美味宫保鸡丁食谱★</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "        </ul>" +
                        "    </body>" +
                        "</html>"))
            newsList.add(NewsUnit("Banana", R.drawable.test_2,"丹爷",
                "2022-1-1","<!DOCTYPE html>" +
                        "<html>" +
                        "    <head>" +
                        "        <meta charset=\"utf-8\">" +
                        "        <title>主页 - Eason_R</title>" +
                        "        <meta name=\"creater\" content=\"Eason_R\">" +
                        "    </head>" +
                        "    <body>" +
                        "        <h1>欢迎来到主页2</h1>" +
                        "        <p>点击下列链接即可跳转</p>" +
                        "        <ul>" +
                        "            <li>主页</li>" +
                        "            <li>跳转测试 - <a href=\"\">论坛</a></li>" +
                        "            <li><a href=\"\">gangsters</a></li>" +
                        "            <li><a href=\"\">美味宫保鸡丁食谱★</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "            <li><a href=\"\">JS测试</a></li>" +
                        "        </ul>" +
                        "    </body>" +
                        "</html>"))

        }
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
//        val viewHolder=ViewHolder(view)
//        viewHolder.itemView.setOnClickListener{
////            val position=viewHolder.adapterPosition
//        }

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