package com.example.forumapp.models

data class EditArticleState (
    var isBanned:Boolean = false,
    var isSetColor:Boolean = false,
    var isSetBgColor:Boolean = false,
    var isOpenHeading:Boolean = false,
    var isAddingAttachment:Boolean = false,
    var isHaveAttachment:Boolean = false,
        )