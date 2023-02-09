package com.example.forumapp.services.dataServices

import com.example.forumapp.models.Post

interface DataServices {
    // get系列方法结合懒加载使用
    fun getPostByTime()
    fun getPostByLastChange()
    fun getNews()
    fun getTags()
    fun getComment(postId:Int)
    fun getResources()    // 获得Post内的图片视频音频资源

    fun doPost(post: Post)
    fun doPostResources()    // todo 使用单独线程流式上传
    fun doLike(id:Int)
    fun doComment()    // todo Comment类
    fun doFollow(userId:Int)
    fun doBanTag()    // todo Tag类
    fun doCollect(id:Int)
    fun doSearch()
}