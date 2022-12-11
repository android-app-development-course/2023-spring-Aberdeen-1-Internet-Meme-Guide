package com.example.forumapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.forumapp.R
import com.example.forumapp.models.NewsUnit

class NewsViewModel:ViewModel() {
    var newsList:ArrayList<NewsUnit>

    init {
        newsList = ArrayList()
        initNews()
    }

    override fun onCleared() {
        newsList = ArrayList()
        super.onCleared()
    }

    private fun initNews() {
        repeat(2) {
            newsList.add(NewsUnit("Apple", R.drawable.test_1,"陈哥",
                "2022-12-1",
                "<!DOCTYPE html>" +
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