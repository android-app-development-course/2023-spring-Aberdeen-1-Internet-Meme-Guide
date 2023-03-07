package com.example.forumapp.services.http



interface UserHttp {
    /**
     * 注册用户
     */
    fun addNewUser()

    /**
     * 根据邮箱验证码和用户uid激活账号
     */
    fun activateUser()

    /**
     * 邮箱+密码登录
     */
    fun loginByEmail()

    /**
     * 手机号+密码登录
     */
    fun loginByPhoneAndPwd()

    /**
     * 手机号+验证码登录
     */
    fun loginByPhone()

    /**
     * 根据token获取最新用户信息（用来获取号主信息）
     */
    fun getUserByToken()

    /**
     * 根据用户uid获取用户信息（用来获取其他账号信息）
     */
    fun getUserById()

    /**
     * 更新用户个人信息
     */
    fun updateUser()

    /**
     * 根据用户uid获取关注列表
     */
    fun getFollowById()

    /**
     * 根据用户uid获取粉丝列表
     */
    fun getFansById()

    /**
     * 根据作者uid获取所有帖子的列表
     */
    fun getPostById()

    /**
     * 根据用户uid获取账户消息
     * 消息包括：活动通知，关注者的更新通知，账号处理通知，账号安全通知等
     */
    fun getMessageById()

    /**
     * 根据用户uid获取封禁tag列表
     */
    fun getBanTagsById()

    /**
     * 根据用户uid更新屏蔽tag列表
     */
    fun updateBanTagById()

    /**
     * 根据用户uid更新用户头像
     */
    fun updateBandageById()

    /**
     * 根据用户uid获取收藏列表
     */
    fun getCollectionById()
}