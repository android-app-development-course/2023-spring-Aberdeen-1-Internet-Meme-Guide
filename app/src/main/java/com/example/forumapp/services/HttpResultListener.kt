package com.example.forumapp.services

@SuppressWarnings("ALL")
interface HttpResultListener {
    fun onSuccess(result:HashMap<String,Any>)

    fun onFailure(error:String)
}