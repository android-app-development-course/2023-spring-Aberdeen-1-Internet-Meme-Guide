package server

import retrofit2.http.POST

interface ServiceApi {
    @POST("card-user/xxx") //这个不用描述吧？懂retrofit的都知道，代表的是请求方式以及请求地址
    suspend fun getUserGotoTest():BaseResult<UserJumpConfigBean> //注意到开头的suspend关键字了吗？它很重要，因为协程体调用外部的方法，它必须是suspend的，否则会报错
}


//贴一下BaseResult代码，大部分的约束也应该如此
data class BaseResult <T>(
    val code :String,
    val success:Boolean,
    val message:String,
    val time:String,
    val data: T

)