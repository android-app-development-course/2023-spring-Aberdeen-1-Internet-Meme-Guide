package com.example.forumapp.models

import java.io.Serializable

open class Article(
    var type:String,
    var title: String,
    var content: String,
    var author: String,
    var time: String,
    var pictures: Array<String>,
    var videos: Array<String>,
    var files: Array<String>,
    var vote: String,
    var status: String
) :Serializable {
}
