package com.example.appdevelopment

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class explaination_memes : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val explainationMemes = mutableListOf<ExplainationMemes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.explaination_memes)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val imgbtn = findViewById<ImageView>(R.id.pic1)
        val postnavbtn = findViewById<FloatingActionButton>(R.id.postNaviBtn)
        val userName = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE) ?: "陈哥"

            explainationMemes.add(ExplainationMemes(1, R.drawable.pic2, "泰裤辣", "34万浏览",R.drawable.pic3, "只因你太美", "27万浏览"))
            explainationMemes.add(ExplainationMemes(2, R.drawable.powerman, "大力王", "29万浏览" ,R.drawable.xiaodaidai, "小呆呆", "22万浏览"))
            explainationMemes.add(ExplainationMemes(3, R.drawable.wujing, "吴京", "15万浏览" ,R.drawable.nsdd, "NSDD", "235万浏览"))
            // 可以添加更多数据


        recyclerView = findViewById(R.id.explaination_rv)
        recyclerView.adapter = ExplainationMemesAdapter(explainationMemes, this)
        recyclerView.layoutManager = LinearLayoutManager(this)

        postnavbtn.setOnClickListener {
            val intent = Intent(this, deliver::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        imgbtn.setOnClickListener {
            val intent = Intent(this, detail_meme2::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        postnavbtn.setOnClickListener {
            val intent = Intent(this, deliver::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        postnavbtn.setOnClickListener {
            val intent = Intent(this, deliver::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
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