package com.example.appdevelopment

import android.content.Intent
import android.os.Bundle
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




        // 加入折叠栏数据
        collapsePanels.add(CollapsePanel(1, "YYSY,全名叫有一说一，常用于表达自己观点前作为开头句使用"))
        collapsePanels.add(CollapsePanel(2, "该梗出自抖音上的不露脸特效西瓜条，不露脸的特效拍摄的内容可以是五花八门的"))
        collapsePanels.add(CollapsePanel(3, "折叠栏3的内容"))
        collapsePanels.add(CollapsePanel(4, "折叠栏4的内容"))
        collapsePanels.add(CollapsePanel(5, "折叠栏5的内容"))

        // 找到 RecyclerView
        recyclerView = findViewById(R.id.rv_panels)

        // 设置 RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CollapsePanelAdapter(collapsePanels)


        // 找到搜索栏 EditText
        mSearchEditText = findViewById(R.id.搜索栏)

        // 设置搜索栏的点击事件监听器
        mSearchEditText.setOnClickListener {
            // 当搜索栏被点击时调用此方法
            val intent = Intent(this, search_page::class.java)
            startActivity(intent)
        }

        postnavbtn.setOnClickListener {
            val intent = Intent(this, deliver::class.java)
            startActivity(intent)
        }

        yysy.setOnClickListener {
            val intent = Intent(this, explaination_memes::class.java)
            startActivity(intent)
        }

        //底部导航栏
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
                R.id.postNaviBtn -> {
                    val intent = Intent(this, deliver::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }

    }

}



