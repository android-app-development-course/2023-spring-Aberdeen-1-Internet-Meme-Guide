package com.example.appdevelopment

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
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



