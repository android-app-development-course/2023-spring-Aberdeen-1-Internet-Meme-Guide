package com.example.forumapp.models

import java.io.Serializable

data class Article(val title:String,
                   val content:String,
                   val author:String,
                   val time:String,
                   val tags:Array<String>,
                   val pictures:Array<String>,
                   val videos:Array<String>,
                   val files:Array<String>,
                   val vote:String,
                   val likes:Int,
                   val collect:Int,
                   val share:Int,
                   val comment:Int,
                   val status:String):Serializable {}
