package com.example.forumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigationBarView.OnItemSelectedListener { item ->
            when(item.itemId){
                R.id.newsNaviBtn -> {
                    val intent= Intent(this,MainActivity::class.java)
                    startActivity(intent)
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
}