package com.example.forumapp

import android.app.Application
import org.xutils.x

class ForumApp:Application() {
    override fun onCreate() {
        super.onCreate()
        x.Ext.init(this);
    }
}