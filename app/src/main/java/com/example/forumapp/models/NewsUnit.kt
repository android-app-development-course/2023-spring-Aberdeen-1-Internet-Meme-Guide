package com.example.forumapp.models

import java.io.Serializable


data class NewsUnit(val title:String,
                    val imageId:Int,
                    val author:String,
                    val time:String,
                    val content:String
                    ): Serializable {}