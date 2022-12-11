package com.example.forumapp.services

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.xutils.common.Callback
import org.xutils.http.RequestParams
import org.xutils.x

class UserRepository {
    val tag:String = "UserHttpUtil"
    private val uri:String = "192.168.1.1:80"

    suspend fun login(params:RequestParams):Callback.Cancelable{
        return withContext(Dispatchers.IO){
            params.uri = "$uri/users/login"
            x.http().post(params,object:Callback.CommonCallback<String>{
                var err = false
                var hashMap:HashMap<String,Any>? = null

                override fun onSuccess(result: String?) {
                    if(result != null){
                        hashMap = JsonUtil.json2HashMap(result)
                        Result.Success(hashMap)
                    }
                }

                override fun onError(ex: Throwable?, isOnCallback: Boolean) {
                    ex?.printStackTrace()
                    err = true
                    Result.Error(IllegalArgumentException("Error happened"))
                }

                override fun onCancelled(cex: Callback.CancelledException?) {
                    cex?.printStackTrace()
                    err = false
                }

                override fun onFinished() {
                    if(!err && hashMap!=null){
                        Log.d(tag, "onFinished: register done. "+hashMap.toString())

                    }else{
                        Log.d(tag, "onFinished: register failed. "+
                                (hashMap?.get("message") ?: ""))
                    }
                }
            })
        }
    }

    suspend fun register(params:RequestParams):Callback.Cancelable {
        return  withContext(Dispatchers.IO){
            params.uri = "$uri/users/registry"
            x.http().post(params, object: Callback.CommonCallback<String>{
                var err = false
                var hashMap:HashMap<String,Any>? = null

                override fun onSuccess(result: String?) {
                    if(result != null){
                        hashMap = JsonUtil.json2HashMap(result)
                        Result.Success(hashMap)
                    }
                }

                override fun onError(ex: Throwable?, isOnCallback: Boolean) {
                    ex?.printStackTrace()
                    err = true
                    Result.Error(IllegalArgumentException("Error happened"))
                }

                override fun onCancelled(cex: Callback.CancelledException?) {
                    cex?.printStackTrace()
                    err = false
                }

                override fun onFinished() {
                    if(!err && hashMap!=null){
                        Log.d(tag, "onFinished: register done. "+hashMap.toString())

                    }else{
                        Log.d(tag, "onFinished: register failed. "+
                                (hashMap?.get("message") ?: ""))
                    }
                }
            })
        }
    }
}