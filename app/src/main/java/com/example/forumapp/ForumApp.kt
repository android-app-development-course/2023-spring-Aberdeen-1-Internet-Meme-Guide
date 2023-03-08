package com.example.forumapp

import android.app.Application
import org.xutils.x
import server.RetrofitManager

class ForumApp:Application() {
    override fun onCreate() {
        RetrofitManager.instance.init("http://192.168.1.1")
        super.onCreate()
        x.Ext.init(this);
    }
}