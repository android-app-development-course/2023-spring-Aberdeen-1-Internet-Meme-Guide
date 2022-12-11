package com.example.forumapp.models

data class ArticleUiState (
    val isSignedIn:Boolean = false,
    var isFetching:Boolean = false,
    var isCommenting:Boolean = false,
        )