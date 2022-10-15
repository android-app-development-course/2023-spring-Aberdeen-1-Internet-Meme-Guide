package com.example.forumapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.forumapp.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_login)

        val acEdit = findViewById<EditText>(R.id.accountEdit)
        val pwEdit = findViewById<EditText>(R.id.passwordEdit)
        val btn = findViewById<Button>(R.id.loginButton)
        btn.setOnClickListener {
            val loginPass = acEdit.text.toString()    // 获取EditText的内容
            val passWord = pwEdit.text.toString()
//            Toast.makeText(this,
//                "Entering account:$loginPass",
//                Toast.LENGTH_SHORT).show()
//        }
            login(loginPass, passWord)
        }
    }

    private fun login(loginPass: String, passWord: String) {
        // TODO 处理登录校验与保存context
    }
}


