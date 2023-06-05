package com.example.appdevelopment

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    // 在 Activity 中定义一个 EditText 对象
    private lateinit var mSearchEditText: EditText
    private lateinit var tvPanelContent: TextView
    private lateinit var imgExpand: ImageView
    private lateinit var tvPanelContent2: TextView
    private lateinit var imgExpand2: ImageView
    private var isExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val yysy = findViewById<TextView>(R.id.YYSY)

        // 找到搜索栏 EditText
        mSearchEditText = findViewById(R.id.搜索栏)

        // 设置搜索栏的点击事件监听器
        mSearchEditText.setOnClickListener {
            // 当搜索栏被点击时调用此方法
            val intent = Intent(this, search_page::class.java)
            startActivity(intent)
        }


        yysy.setOnClickListener {
            val intent = Intent(this, explaination_memes::class.java)
            startActivity(intent)
        }
        tvPanelContent = findViewById(R.id.tv_panel_content)
        imgExpand = findViewById(R.id.img_expand)
        tvPanelContent2 = findViewById(R.id.tv_panel_content2)
        imgExpand2 = findViewById(R.id.img_expand2)

        imgExpand.setOnClickListener {
            isExpanded = !isExpanded

            if (isExpanded) {
                tvPanelContent.maxLines = Integer.MAX_VALUE
                tvPanelContent.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                imgExpand.setImageResource(R.drawable.ic_arrow_up)
            } else {
                tvPanelContent.maxLines = 10
                tvPanelContent.layoutParams.height = resources.getDimensionPixelSize(R.dimen.text_height)
                imgExpand.setImageResource(R.drawable.ic_arrow_down)
            }

        }
        imgExpand2.setOnClickListener {
            isExpanded = !isExpanded

            if (isExpanded) {
                tvPanelContent2.maxLines = Integer.MAX_VALUE
                tvPanelContent2.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                imgExpand2.setImageResource(R.drawable.ic_arrow_up)
            } else {
                tvPanelContent2.maxLines = 10
                tvPanelContent2.layoutParams.height = resources.getDimensionPixelSize(R.dimen.text_height)
                imgExpand2.setImageResource(R.drawable.ic_arrow_down)
            }

        }
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



