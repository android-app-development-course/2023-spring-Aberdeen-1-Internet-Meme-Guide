package com.example.appdevelopment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.util.*



class search_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_page)

        val backbtn = findViewById<View>(R.id.返回键)
        val yysy = findViewById<TextView>(R.id.textView8)
        val tkl = findViewById<TextView>(R.id.泰裤辣)
        val jntm = findViewById<TextView>(R.id.只因太美)
        val searchbutton = findViewById<View>(R.id.searchbutton)
        val userName = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE) ?: "陈哥"


        searchbutton.setOnClickListener {
            val intent = Intent(this, detail_meme2::class.java)
            var timer = Timer()
            class MyTimerTask():TimerTask(){
                override fun run() {
                    startActivity(intent)
                }
            }
            var timerTask=MyTimerTask()
            timer.schedule(timerTask, 600)

        }




        jntm.setOnClickListener {
            val intent = Intent(this, details_meme::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        tkl.setOnClickListener {
            val intent = Intent(this, detail_meme3::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        yysy.setOnClickListener {
            val intent = Intent(this, detail_meme2::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        backbtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }


    }
}
