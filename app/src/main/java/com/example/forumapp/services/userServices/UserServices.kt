package com.example.forumapp.services.userServices

import com.example.forumapp.models.User

interface UserServices {

    // 登录注册相关
    fun doLoginByEmail(email:String, password:String)

    /**
     * 请求验证码用于邮箱激活账号
     */
    fun getVerifyCode(phone:String)

    /**
     * 根据手机号+密码登录，并保存Token到localStorage
     */
    fun doLoginByPhone(phone:String, verifyCode: String)

    /**
     * 注册新的用户
     */
    fun doRegister(user:User)

    /**
     * 根据邮箱激活码激活账号
     */
    fun doVerifyAccountByEmailCode(emailCode:String)

    // 收藏，历史，屏蔽与其他
    /**
     * 更新用户信息
     */
    fun doUpdatePersonalInfo(user:User)

    /**
     * 获取个人信息
     */
    fun getPersonalInfo()    // 获取个人信息使用该Service，后端校验token

    /**
     * 获取他人账号信息
     */
    fun getUserInfo(id:Int)

    /**
     * 上传头像
     */
    fun doUploadBandage()    // todo 使用单独一个线程上传，该方法仅用于上传头像，更新信息用update

    /**
     * 获得收藏列表
     */
    fun getCollections()

    /**
     * 获取历史记录列表
     */
    fun getHistory()

    /**
     * 获取屏蔽tag列表
     */
    fun getBanTags()

    /**
     * 获取个人发布的帖子
     */
    fun getMyWorks()
}