package com.example.forumapp.models

import java.io.Serializable


data class NewsUnit(
    val title:String,
    val imageId:Int,
//    val image:String = "",
    val author:String,
    val time:String,
    val content:String
    ): Serializable