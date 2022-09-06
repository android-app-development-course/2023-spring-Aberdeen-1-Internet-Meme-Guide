package com.example.forumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationBarView
import org.xutils.view.annotation.ContentView
import org.xutils.view.annotation.Event

@ContentView(R.layout.activity_main)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

//        @Event(R.id.postNaviBtn)
//        fun onPlusBtnClicked(view: View){
//
//        }
    }
}