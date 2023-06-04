package com.example.appdevelopment

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val yysy = findViewById<TextView>(R.id.YYSY)
        yysy.setOnClickListener {
            val intent = Intent(this, explaination_memes::class.java)
            startActivity(intent)
        }

    }

}



