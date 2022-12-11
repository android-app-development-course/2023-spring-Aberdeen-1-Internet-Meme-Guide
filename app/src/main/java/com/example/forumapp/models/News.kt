package com.example.forumapp.models

import org.xutils.http.RequestParams
import java.io.Serializable

data class News(
    val newsId:String = "",
    val title:String = "",
    val content:String = "",
    val author:String = "",
    val time:String = "",
    val pictures:List<String> = listOf(),
    val videos:List<String> = listOf(),
    val status:String = "",
    val numOfLikes:Int = 0,
    val numOfCollect:Int = 0,
    val numOfComment:Int = 0,
):Serializable

