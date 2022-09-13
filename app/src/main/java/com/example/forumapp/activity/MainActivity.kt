package com.example.forumapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.Fragment
import com.example.forumapp.fragment.NewsFragment
import com.example.forumapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)  // 放在setContentView之前
        setContentView(R.layout.activity_main)
        replaceMainContent(NewsFragment())  // 默认打开新闻页

        // 新闻处理


        NavigationBarView.OnItemSelectedListener { item ->
            when(item.itemId){
                R.id.newsNaviBtn -> {
                    replaceMainContent(NewsFragment())
                    true
                }
                R.id.passageNaviBtn -> {
                    // TODO: 加路由

                    true
                }
                R.id.postNaviBtn -> {
                    // TODO: 加路由
                    true
                }
                R.id.myNaviBtn -> {
                    // TODO: 加路由
                    true
                }
                else -> false
            }
        }

        val postBtn=findViewById<FloatingActionButton>(R.id.postNaviBtn)
        postBtn.setOnClickListener{
            // TODO
        }
    }

    private fun replaceMainContent(fragment:Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.mainArea,fragment)
        transaction.commit()
    }
}