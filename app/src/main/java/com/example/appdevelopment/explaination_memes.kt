package com.example.appdevelopment

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class explaination_memes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.explaination_memes)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val explainationMemesList = listOf(
            ExplainationMemes(1, R.drawable.pic2, "泰裤辣", "34万浏览",R.drawable.pic3, "只因你太美", "27万浏览"),
            ExplainationMemes(2, R.drawable.powerman, "大力王", "29万浏览", R.drawable.xiaodaidai, "小呆呆", "22万浏览"),
            ExplainationMemes(3, R.drawable.wujing, "吴京", "15万浏览", R.drawable.wujing, "YYSY", "235万浏览"),
            // 可以添加更多数据
        )

        val recyclerView = findViewById<RecyclerView>(R.id.explaination_rv)
        recyclerView.adapter = ExplainationMemesAdapter(explainationMemesList)
        recyclerView.layoutManager = LinearLayoutManager(this)


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