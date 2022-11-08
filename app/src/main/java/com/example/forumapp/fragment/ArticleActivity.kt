package com.example.forumapp.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.forumapp.R


class ArticleActivity() : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val replyFragment = findViewById<ConstraintLayout>(R.id.relativeLayout)
        val replyBtn = findViewById<Button>(R.id.replybutton)
        replyBtn.setOnClickListener {
            replyBtn.visibility = View.INVISIBLE
            replyFragment.visibility = View.VISIBLE
        }
    }
}





