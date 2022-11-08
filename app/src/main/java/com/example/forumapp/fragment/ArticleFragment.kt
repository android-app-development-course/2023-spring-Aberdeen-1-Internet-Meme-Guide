package com.example.forumapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.forumapp.R
import com.rex.editor.view.RichEditorNew

class ArticleFragment : Fragment() {

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


        val richTextContent = view.findViewById<RichEditorNew>(R.id.richText)
        val htmlTest = "<!DOCTYPE html>" +
                "<html>" +
                "    <head>" +
                "        <meta charset=\"utf-8\">" +
                "        <title>主页 - Eason_R</title>" +
                "        <meta name=\"creater\" content=\"Eason_R\">" +
                "    </head>" +
                "    <body>" +
                "        <h1>欢迎来到主页</h1>" +
                "        <p>点击下列链接即可跳转</p>" +
                "        <ul>" +
                "            <li>主页</li>" +
                "            <li>跳转测试 - <a href=\"\">论坛</a></li>" +
                "            <li><a href=\"\">gangsters</a></li>" +
                "            <li><a href=\"\">美味宫保鸡丁食谱★</a></li>" +
                "            <li><a href=\"\">JS测试</a></li>" +
                "        </ul>" +
                "    </body>" +
                "</html>"

//        // 检测是否拥有权限
//        if(ContextCompat.checkSelfPermission(this.requireContext(),
//                android.Manifest.permission.READ_EXTERNAL_STORAGE)
//            != PackageManager.PERMISSION_GRANTED){
//
//        }

        richTextContent.loadRichEditorCode(htmlTest)

        return view
    }


}