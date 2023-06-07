package com.example.appdevelopment

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class detail_meme3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_meme3)
        val userName = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE) ?: "陈哥"
        val backbtn = findViewById<ImageView>(R.id.imageView7)
        backbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

    }
}