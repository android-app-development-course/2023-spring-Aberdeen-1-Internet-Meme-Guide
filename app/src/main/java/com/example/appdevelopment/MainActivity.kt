package com.example.appdevelopment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    val yysy = findViewById<TextView>(R.id.YYSY)
        yysy.setOnClickListener{
            val intent = Intent(this, explaination_memes::class.java)
            startActivity(intent)
        }
    }

}