package com.example.appdevelopment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class mypage_main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage_main)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        val button1 = findViewById<Button>(R.id.my_work)
        button1.setOnClickListener {
            // 处理“我的创作”按钮点击事件的代码
            val intent = Intent(this, mypage_work::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.my_draft)
        button2.setOnClickListener {
            // 处理“草稿箱”按钮点击事件的代码
        }

        val button3 = findViewById<Button>(R.id.my_history)
        button3.setOnClickListener {
            // 处理“浏览历史”按钮点击事件的代码
        }

        val button4 = findViewById<Button>(R.id.my_like)
        button4.setOnClickListener {
            // 处理“我的点赞”按钮点击事件的代码
        }


        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeNaviBtn -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.findNaviBtn -> {
                    val intent = Intent(this, explaination_memes::class.java)
                    startActivity(intent)
                    true
                }
                R.id.messageNaviBtn -> {
                    val intent = Intent(this, explaination_memes::class.java)
                    startActivity(intent)
                    true
                }
                R.id.myNaviBtn -> {
                    val intent = Intent(this, mypage_main::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }


    }

}