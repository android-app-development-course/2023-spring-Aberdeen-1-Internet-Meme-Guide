package com.example.forumapp

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.rex.editor.view.RichEditor

class ArticleEditActivity : AppCompatActivity() {
    private var isTextColorChanged = false
    private var isTextBgColorChanged = false
    private val getImages = registerForActivityResult(
        ActivityResultContracts.GetMultipleContents()){
        uriList: List<Uri> ->
        if(uriList.isNotEmpty()){
            insertImages(uriList)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_edit)

        findViewById<MaterialToolbar>(R.id.postTopBarEdit).setNavigationOnClickListener {
            finish()
        }

        val richEditor = findViewById<RichEditor>(R.id.editRichTextContent)
        richEditor.setPadding(10,0,10,0)
        initActions(richEditor)



    }

    private fun initActions(richEditor: RichEditor) {
        findViewById<MaterialToolbar>(R.id.postTopBarEdit).setOnMenuItemClickListener {
            item ->
            when(item.itemId){
                R.id.action_undo -> {
                    richEditor.undo()
                    true
                }
                R.id.action_redo -> {
                    richEditor.redo()
                    true
                }
                R.id.action_publish -> {
                    true
                }
                else -> { false }
            }
        }

        findViewById<ImageButton>(R.id.action_fragment).setOnClickListener {  }

        findViewById<ImageButton>(R.id.action_bold).setOnClickListener {
            richEditor.setBold()
        }

        findViewById<ImageButton>(R.id.action_italic).setOnClickListener {
            richEditor.setItalic()
        }

        findViewById<ImageButton>(R.id.action_subscript).setOnClickListener {
            richEditor.setSubscript()
        }

        findViewById<ImageButton>(R.id.action_superscript).setOnClickListener {
            richEditor.setSuperscript()
        }

        findViewById<ImageButton>(R.id.action_strikethrough).setOnClickListener {
            richEditor.setStrikeThrough()
        }

        findViewById<ImageButton>(R.id.action_underline).setOnClickListener {
            richEditor.setUnderline()
        }

        val optionBar = findViewById<LinearLayout>(R.id.postOptionBar)
        optionBar.visibility = View.GONE

        findViewById<ImageButton>(R.id.action_heading).setOnClickListener {
            if (optionBar.visibility == View.GONE){
                optionBar.visibility = View.VISIBLE
            }else{
                optionBar.visibility = View.GONE
            }
        }

        findViewById<ImageView>(R.id.ic_heading1).setOnClickListener {
            richEditor.setHeading(1)
        }

        // other headings or heading selection

        findViewById<ImageButton>(R.id.action_txt_color).setOnClickListener {
            if (isTextColorChanged){
                richEditor.setTextColor(Color.BLACK)
                isTextColorChanged = false
            }else{
                // todo 添加调色盘
                richEditor.setTextColor(Color.RED)
                isTextColorChanged = true
            }

        }

        findViewById<ImageButton>(R.id.action_bg_color).setOnClickListener {
            if (isTextBgColorChanged){
                richEditor.setTextColor(Color.TRANSPARENT)
                isTextBgColorChanged = false
            }else{
                // todo 添加调色盘
                richEditor.setTextColor(Color.YELLOW)
                isTextBgColorChanged = true
            }

        }

        findViewById<ImageButton>(R.id.action_indent).setOnClickListener {
            richEditor.setIndent()
        }

        findViewById<ImageButton>(R.id.action_indent_decrease).setOnClickListener {
            richEditor.setOutdent()
        }

        findViewById<ImageButton>(R.id.action_align_left).setOnClickListener {
            richEditor.setAlignLeft()
        }

        findViewById<ImageButton>(R.id.action_align_center).setOnClickListener {
            richEditor.setAlignCenter()
        }

        findViewById<ImageButton>(R.id.action_align_right).setOnClickListener {
            richEditor.setAlignRight()
        }

        findViewById<ImageButton>(R.id.action_insert_bullets).setOnClickListener {
            richEditor.setBullets()
        }

        findViewById<ImageButton>(R.id.action_insert_numbers).setOnClickListener {
            richEditor.setNumbers()
        }

        findViewById<ImageButton>(R.id.action_blockquote).setOnClickListener {
            richEditor.setBlockquote()
        }

        findViewById<ImageButton>(R.id.action_insert_image).setOnClickListener {
            getImages.launch("image/*")
        }

        findViewById<ImageButton>(R.id.action_insert_audio).setOnClickListener {
            // todo
        }

        findViewById<ImageButton>(R.id.action_insert_video).setOnClickListener {
            //todo
        }

        findViewById<ImageButton>(R.id.action_insert_link).setOnClickListener {
            insertLink()
        }


    }

    private fun insertImages(uriList: List<Uri>) {
        val richEditor = findViewById<RichEditor>(R.id.editRichTextContent)
        for (uri in uriList){
            richEditor.insertImage(uri.toString(),"picture",
                "margin-top:10px;margin-bottom:10px;max-width:100%;")
        }
    }

    private fun insertLink(){
        // todo
    }

    private fun encodeToBase64(content:String){
        // todo
    }
}