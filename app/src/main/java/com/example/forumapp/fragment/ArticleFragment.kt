package com.example.forumapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.forumapp.R

class fragment_article : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_article, container, false)
        val replyFragment = view.findViewById<ConstraintLayout>(R.id.constraintLayout2)
        val replyBtn = view.findViewById<Button>(R.id.replybutton)
        replyBtn.setOnClickListener {
            replyBtn.visibility = View.INVISIBLE
            replyFragment.visibility = View.VISIBLE
        }

        // Inflate the layout for this fragment
        return view
    }


}