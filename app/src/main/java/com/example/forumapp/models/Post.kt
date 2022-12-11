package com.example.forumapp.models

import java.io.Serializable

data class Post(
    val postId:Int = 0,
    val title:String = "",
    val content:String = "",
    val author:String = "",
    val publicationTime:String = "",
    val lastUpdateTime:String = "",
    val pictures:List<String> = listOf(),
    val videos:List<String> = listOf(),
    val status:String = "",
    val numOfLikes:Int = 0,
    val numOfCollect:Int = 0,
    val numOfComment:Int = 0,
    val readTimeMin:Int = 0,
):Serializable
