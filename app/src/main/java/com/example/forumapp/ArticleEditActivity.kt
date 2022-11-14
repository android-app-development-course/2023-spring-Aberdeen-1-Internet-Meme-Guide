package com.example.forumapp

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import jp.wasabeef.richeditor.RichEditor

class ArticleEditActivity : AppCompatActivity() {
    private var isTextColorChanged = false
    private var isTextBgColorChanged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_edit)

        findViewById<MaterialToolbar>(R.id.postTopBarEdit).setNavigationOnClickListener {
            finish()
        }

        val richEditor = findViewById<RichEditor>(R.id.editRichTextContent)
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

        findViewById<ImageButton>(R.id.action_heading1).setOnClickListener {
            richEditor.setHeading(1)
        }

        // other headings

        findViewById<ImageButton>(R.id.action_txt_color).setOnClickListener {
            if (isTextColorChanged){
                richEditor.setTextColor(Color.BLACK)
                isTextColorChanged = false
            }else{
                richEditor.setTextColor(Color.RED)
                isTextColorChanged = true
            }
            // todo 添加调色盘
        }

        findViewById<ImageButton>(R.id.action_bg_color).setOnClickListener {
            if (isTextBgColorChanged){
                richEditor.setTextColor(Color.TRANSPARENT)
                isTextBgColorChanged = false
            }else{
                richEditor.setTextColor(Color.YELLOW)
                isTextBgColorChanged = true
            }
            // todo 添加调色盘
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
            insertImage()
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

    private fun insertImage(){
        // todo 设置图片导入上传
    }

    private fun insertLink(){
        // todo
    }
}