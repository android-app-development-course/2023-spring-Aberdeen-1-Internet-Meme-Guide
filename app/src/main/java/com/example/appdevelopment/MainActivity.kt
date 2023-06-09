package com.example.appdevelopment

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val collapsePanels = mutableListOf<CollapsePanel>()
    private lateinit var mSearchEditText: EditText
//    private lateinit var tvPanelContent: TextView
//    private lateinit var imgExpand: ImageView
//    private lateinit var tvPanelContent2: TextView
//    private lateinit var imgExpand2: ImageView
//    private var isExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val yysy = findViewById<TextView>(R.id.YYSY)
        val postnavbtn = findViewById<FloatingActionButton>(R.id.postNaviBtn)
        val userName = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE) ?: "pqpq"


        // 加入折叠栏数据
        collapsePanels.add(CollapsePanel(1, "YYSY","YYSY,全名叫有一说一，常用于表达自己观点前作为开头句使用", "18", "June 6"))
        collapsePanels.add(CollapsePanel(2, "泰裤辣","泰裤辣”是一个近期流行的网络梗，源自于小鬼王琳凯在演唱会上说的一句话" , "20", "June 7"))
        collapsePanels.add(CollapsePanel(3, "鸡你太美","鸡你太美，是一句网络流行语，为2016年11月29日SWIN-S发布的歌曲《只因你太美》的空耳。", "17", "June 8"))
        collapsePanels.add(CollapsePanel(4, "家人们谁懂","该梗出自抖音上的不露脸特效西瓜条，不露脸的特效拍摄的内容可以是五花八门的", "45", "June 5"))
//        collapsePanels.add(CollapsePanel(5, "NSDD","现如今，很多人开始用拼音首字母来代替自己想要表达的意思，这是一种在零零后群体中比较流行的字母缩写流，例如“啊我死了”被说成“awsl”", "14", "June 6"))


        // 找到 RecyclerView
        recyclerView = findViewById(R.id.rv_panels)

        // 设置 RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CollapsePanelAdapter(collapsePanels)

        if (intent != null && intent.hasExtra("newPanel")) {
            val newPanel = intent.getParcelableExtra<CollapsePanel>("newPanel")
            if (newPanel != null) {
                collapsePanels.add(newPanel)
            }
            recyclerView.adapter?.notifyDataSetChanged()
        }


        // 找到搜索栏 EditText
        mSearchEditText = findViewById(R.id.搜索栏)

        // 设置搜索栏的点击事件监听器
        mSearchEditText.setOnClickListener {
            // 当搜索栏被点击时调用此方法
            val intent = Intent(this, search_page::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        postnavbtn.setOnClickListener {
            val intent = Intent(this, deliver::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        yysy.setOnClickListener {
            val intent = Intent(this, explaination_memes::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
            startActivity(intent)
        }

        //底部导航栏
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
                    val intent = if (userName == "pqpq") {
                        Intent(this, LoginActivity::class.java)
                    } else {
                        Intent(this, mypage_main::class.java).apply {
                            putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
                    }
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



