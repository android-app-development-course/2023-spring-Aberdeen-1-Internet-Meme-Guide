package com.example.forumapp.models

class News(
    type:String = "news",
    title: String,
    content: String,
    author: String,
    time: String,
    pictures: Array<String>,
    videos: Array<String>,
    files: Array<String>,
    vote: String,
    var likes: Int,
    var collect: Int,
    var share: Int,
    var comment: Int,
    status: String


) : Article(
    type,
    title,
    content,
    author,
    time,
    pictures,
    videos,
    files,
    vote,
    status
) {
}