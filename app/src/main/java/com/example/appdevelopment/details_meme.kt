package com.example.appdevelopment

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class details_meme: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_meme)
        val userName = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE) ?: "陈哥"
        val backtn = findViewById<ImageView>(R.id.imageView7)

        backtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }


    }
}