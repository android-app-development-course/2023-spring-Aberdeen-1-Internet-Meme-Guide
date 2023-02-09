package com.example.forumapp.services.userServices

import com.example.forumapp.models.User

interface UserServices {
    // 登录注册相关
    fun doLoginByEmail(email:String, password:String)
    fun getVerifyCode(phone:String)
    fun doLoginByPhone(phone:String, verifyCode: String)
    fun doRegister(user:User)
    fun doVerifyAccountByEmailCode(emailCode:String)

    // 收藏，历史，屏蔽与其他
    fun doUpdatePersonalInfo(user:User)
    fun getPersonalInfo(id:Int)    // 获取他人信息与个人信息统一使用该Service，由后端比对Token即可区分是否为本人
    fun doUploadBandage()    // todo 使用单独线程流式上传
    fun getCollections()
    fun getHistory()
    fun getBanTags()
    fun getMyWorks()
}