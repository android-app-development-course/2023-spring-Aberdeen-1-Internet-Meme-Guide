package com.example.forumapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.forumapp.R

//之前的activity

//class LoginActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
//        setContentView(R.layout.activity_login)
//
//        val acEdit = findViewById<EditText>(R.id.accountEdit)
//        val pwEdit = findViewById<EditText>(R.id.passwordEdit)
//        val btn = findViewById<Button>(R.id.loginButton)
//        btn.setOnClickListener {
//            val loginPass = acEdit.text.toString()    // 获取EditText的内容
//            val passWord = pwEdit.text.toString()
////            Toast.makeText(this,
////                "Entering account:$loginPass",
////                Toast.LENGTH_SHORT).show()
////        }
//            login(loginPass, passWord)
//        }
//    }
//
//    private fun login(loginPass: String, passWord: String) {
//        // TODO 处理登录校验与保存context
//    }
//}



class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login, container, false)
        val acEdit = view.findViewById<EditText>(R.id.accountTextLayout)
        val pwEdit = view.findViewById<EditText>(R.id.passwordTextLayout)
        val btn = view.findViewById<Button>(R.id.loginButton)


        btn.setOnClickListener {
            val loginPass = acEdit.text.toString()    // 获取EditText的内容
            val passWord = pwEdit.text.toString()
            Toast.makeText(
                view.getContext(),
                "Entering account:$loginPass",
                Toast.LENGTH_SHORT
            ).show()
        }
        return view

    }
    private fun login(loginPass: String, passWord: String) {
        //TODO 处理登录校验与保存context
        //使用okhtttputils将phone和password发送给服务器
        OkHttpUtils.post().url(LoginURL).addParams("phone", phone)
            .addParams("password", pwd).build().execute(object : StringCallback() {
                //成功回调
                override fun onResponse(response: String?) {
                    Log.e("丹爷", "---response---" + response)
                    var model = GsonUtils.jsonToBean<Responses.Login>(response, Responses.Login::class.java)

                    //登录成功
                    if (model.code == "success") {
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    }
                }
                //失败回调
                override fun onError(p0: Request?, e: Exception?) {
                    //请求失败处理回调信息
                    Log.e("丹爷", "---error---" + e!!.message)
                }

            })
    }

    }



