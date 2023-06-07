package com.example.appdevelopment

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.makeramen.roundedimageview.RoundedImageView


class mypage_main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage_main)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val postnavbtn = findViewById<FloatingActionButton>(R.id.postNaviBtn)
        val userName = intent.getStringExtra(EXTRA_MESSAGE) ?: "陈哥"
        val userNameTextView = findViewById<TextView>(R.id.UserName)
        userNameTextView.setText(userName)

        // 处理“头像”点击事件的代码
        val imageView = findViewById<RoundedImageView>(R.id.imageView7)
        imageView.setOnClickListener {
            val intent = Intent(this, mypage_profile::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        // 处理“收藏“点击事件的代码
        val collect = findViewById<TextView>(R.id.textView3)
        collect.setOnClickListener {
            val intent = Intent(this, mypage_collect::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        // 处理“关注“点击事件的代码
        val follow = findViewById<TextView>(R.id.follows)
        follow.setOnClickListener {
            Log.d("MyTag", "111111");
            val intent = Intent(this, mypage_follow::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        val button1 = findViewById<Button>(R.id.my_work)
        button1.setOnClickListener {
            // 处理“我的创作”按钮点击事件的代码
            val intent = Intent(this, mypage_work::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.my_draft)
        button2.setOnClickListener {
            // 处理“草稿箱”按钮点击事件的代码
            val intent = Intent(this, mypage_draft::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        val button3 = findViewById<Button>(R.id.my_history)
        button3.setOnClickListener {
            // 处理“浏览历史”按钮点击事件的代码
            val intent = Intent(this, mypage_history::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        val button4 = findViewById<Button>(R.id.my_like)
        button4.setOnClickListener {
            // 处理“我的点赞”按钮点击事件的代码
            val intent = Intent(this, mypage_liked::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        postnavbtn.setOnClickListener {
            val intent = Intent(this, deliver::class.java)
            startActivity(intent)
        }




        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeNaviBtn -> {
                    val intent = Intent(this, MainActivity::class.java).apply {
                        putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
                    startActivity(intent)
                    true
                }
                R.id.findNaviBtn -> {
                    val intent = Intent(this, explaination_memes::class.java).apply {
                        putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
                    startActivity(intent)
                    true
                }
                R.id.messageNaviBtn -> {
                    val intent = Intent(this, message_memes::class.java).apply {
                        putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
                    startActivity(intent)
                    true
                }
                R.id.myNaviBtn -> {
                    val intent = Intent(this, mypage_main::class.java).apply {
                        putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
                    startActivity(intent)
                    true
                }
                R.id.postNaviBtn -> {
                    val intent = Intent(this, deliver::class.java).apply {
                        putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }


    }

}