package com.example.appdevelopment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class deliver : AppCompatActivity() {
    private val collapsePanels = mutableListOf<CollapsePanel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.deliver)
        val exitbtn = findViewById<ImageView>(R.id.exitbtn)
        val sendbtn = findViewById<TextView>(R.id.sendbtn)


        exitbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        sendbtn.setOnClickListener {
            val newPanel = CollapsePanel(6, "NSDD","现如今，很多人开始用拼音首字母来代替自己想要表达的意思，这是一种在零零后群体中比较流行的字母缩写流，例如“啊我死了”被说成“awsl”", "14", "June 6")
            Log.d("发送成功","成功发布！！")
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("newPanel", newPanel)
            startActivity(intent)
        }


    }
}