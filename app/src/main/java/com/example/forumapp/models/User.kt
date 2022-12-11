package com.example.forumapp.models

class User (
    val id: Int? = null,
    val email: String = "",
    val password:String = "",
    val registerTime:String = "",
    val studentId:String? = null,
    val likes:List<String> = listOf(),
    val collection:List<String> = listOf(),
    val history:List<String> = listOf(),
    val banTag:List<String> = listOf(),
    val subscription:List<Int> = listOf(),
        )