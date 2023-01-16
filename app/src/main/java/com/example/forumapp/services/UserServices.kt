package com.example.forumapp.services

import android.util.Log
import kotlinx.coroutines.withTimeoutOrNull
import org.xutils.common.Callback
import org.xutils.http.RequestParams
import org.xutils.x

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

object UserServices {
    val tag:String = "UserHttpUtil"
    private val uri:String = "192.168.1.1:80"
    var res: HashMap<String,Any>? = null

//    fun initConnect(): Socket {
//        val sc: Socket = Socket("192.168.1.1", 8080) //通过socket连接服务器,参数ip为服务端ip地址，port为服务端监听端口
//        sc.setSoTimeout(10000)  //设置连接超时限制
//        if (sc.isConnected) {    //判断一下是否连上，避免NullPointException
//            System.out.println("connect server successful")
//        } else {
//            System.out.println("connect server failed,now retry...")
//            initConnect()   //没连上就重试一次
//        }
//        return sc
//    }
//
//    fun doLogin(){
//        //todo
//    }

    suspend fun doRegister(params:RequestParams) =
        withTimeoutOrNull(30000){
            params.uri = "$uri/users/registry"
            x.http().post(params, object: Callback.CommonCallback<String>{
                var err = false

                override fun onSuccess(result: String?) {
                    if(result != null){
                        val haspMap = JsonUtil.json2HashMap(result)
                        if(haspMap != null){
//                            res = haspMap
                            HttpResultListener.onSuccess(haspMap)
                        }
                    }
                }

                override fun onError(ex: Throwable?, isOnCallback: Boolean) {
                    ex?.printStackTrace()
                    err = true
                }

                override fun onCancelled(cex: Callback.CancelledException?) {
                    cex?.printStackTrace()
                    err = false
                }

                override fun onFinished() {
                    if(!err){
                        Log.d(tag, "onFinished: register post done. "+res.toString())
                    }else{
                        Log.d(tag, "onFinished: register post failed "+
                                (res?.get("msg") ?: ""))
                    }
                }
            })
        }

    fun postAsync(params: RequestParams, callback:xCall)
}