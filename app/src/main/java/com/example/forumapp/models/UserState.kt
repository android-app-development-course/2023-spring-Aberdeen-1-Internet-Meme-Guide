package com.example.forumapp.models

data class UserState(
    val isLoading:Boolean = false,
    val errorMessage:String? = null,
    val isLoggedIn:Boolean = false,
)