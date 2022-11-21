package com.example.forumapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.forumapp.R
import com.google.android.material.textfield.TextInputEditText
import org.xutils.common.util.DensityUtil
import org.xutils.image.ImageOptions
import org.xutils.x

class LoginActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.login)

        val userBandage = findViewById<ImageView>(R.id.userBandage)
        val imageOption = ImageOptions.Builder()
            .setSize(500,500)
            .setCrop(true)
            .setImageScaleType(ImageView.ScaleType.FIT_CENTER)
            .build()
        x.image().bind(userBandage,"res://"+R.drawable.icons8__user_big,imageOption)

        val acEdit = findViewById<TextInputEditText>(R.id.accountTextField)
        val pwEdit = findViewById<TextInputEditText>(R.id.passwordTextField)
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


