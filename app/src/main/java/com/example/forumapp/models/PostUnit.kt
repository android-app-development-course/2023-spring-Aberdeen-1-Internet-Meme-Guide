package com.example.forumapp.models

import java.io.Serializable

data class PostUnit (
        val title:String,
        val headImageId:Int,
        val author:String,
        val time:String,
        val shortCut:String = "",
        val headImage:String = "",
        ):Serializable