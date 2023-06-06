package com.example.appdevelopment

data class CollapsePanel(
    val id: Int,
    val tittle: String,
    val content: String,
    val likes: String,
    val time: String,
    var isExpanded: Boolean = false


)
