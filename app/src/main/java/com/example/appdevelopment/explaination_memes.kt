package com.example.appdevelopment

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class explaination_memes : AppCompatActivity() {
    private lateinit var tvPanelContent: TextView
    private lateinit var imgExpand: ImageView
    private var isExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.explaination_memes)

         tvPanelContent = findViewById(R.id.tv_panel_content)
         imgExpand = findViewById(R.id.img_expand)

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
    }

}