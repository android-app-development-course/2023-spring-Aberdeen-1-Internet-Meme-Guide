package com.example.appdevelopment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.ImageView
import com.makeramen.roundedimageview.RoundedImageView

class mypage_profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage_profile)
        val userName = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE) ?: "陈哥"
// 处理“返回”按钮点击事件的代码
        val imageView = findViewById<ImageView>(R.id.previous)
        imageView.setOnClickListener {
            val intent = Intent(this, mypage_main::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)

    }
}}