package com.example.appdevelopment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class message_memes : AppCompatActivity(){
    private lateinit var recyclerView: RecyclerView
    private val messageMemes = mutableListOf<MessageMemes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.messages)
            messageMemes.add(MessageMemes(1, R.drawable.pic10,"熊", "你好，我是熊"))
            messageMemes.add(MessageMemes(2, R.drawable.pic11, "鱼王", "你好，我是鱼王"))
            messageMemes.add(MessageMemes(3, R.drawable.pic12, "咚咚咚", "我是咚咚咚，来自未来"))
            messageMemes.add(MessageMemes(4, R.drawable.pic13, "渔王", "你好，我才是真的渔王。"))
            messageMemes.add(MessageMemes(5, R.drawable.pic14, "小熊", "这里是熊的小号。"))
            messageMemes.add(MessageMemes(6, R.drawable.pic15, "丁真", "我是丁真，笑容纯真。"))
            messageMemes.add(MessageMemes(7, R.drawable.pic16, "大熊", "这里有丹的小秘密出售"))


        recyclerView = findViewById(R.id.message_rv)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        recyclerView.adapter = MessageMemesAdapter(messageMemes)
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
                    val intent = Intent(this, message_memes::class.java)
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