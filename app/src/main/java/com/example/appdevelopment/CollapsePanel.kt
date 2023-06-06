package com.example.appdevelopment

data class CollapsePanel(
    val id: Int,
    val tittle: String,
    val content: String,
    var isExpanded: Boolean = false
)
