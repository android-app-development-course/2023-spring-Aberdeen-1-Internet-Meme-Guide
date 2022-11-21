package com.example.forumapp

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.forumapp.models.Article
import com.example.forumapp.models.NewsUnit
import com.google.android.material.appbar.MaterialToolbar
import com.rex.editor.view.RichEditor


class ArticleActivity() : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val replyFragment = findViewById<ConstraintLayout>(R.id.relativeLayout)
        val replyBtn = findViewById<Button>(R.id.replybutton)
        replyBtn.setOnClickListener {
            replyFragment.visibility = View.VISIBLE
        }
        val topAppBar = findViewById<MaterialToolbar>(R.id.postTopBar)
        topAppBar.setNavigationOnClickListener {
            finish()
        }

        fitContent()    // 获取文字信息并填入页面

    }

    private fun fitContent(){
        val richTextContent = findViewById<RichEditor>(R.id.richText)
        val topBar = findViewById<MaterialToolbar>(R.id.postTopBar)
        val type = intent.getStringExtra("type")
        when(type){
            "news" -> {
                val newsObj = intent.getSerializableExtra("obj")
                if (newsObj is NewsUnit){
                    richTextContent.html = newsObj.content
                    topBar.title = newsObj.title
                }
                return
            }
            "post" -> {
                val postObj = intent.getSerializableExtra("obj")
                if (postObj is Article){
                    richTextContent.html = postObj.content
                    topBar.title = postObj.title
                }
                return
            }
        }

    }
}





