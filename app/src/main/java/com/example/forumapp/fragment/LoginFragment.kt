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
import org.json.JSONObject
import java.io.IOException
import java.io.InputStreamReader
import java.net.Socket

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
            login(loginPass, passWord)
        }
        return view

    }
}

private fun login(loginPass: String, passWord: String) {
    val sc = initConnect()
    val obj = JSONObject()
    obj.put(loginPass, passWord)
    val msg = obj.toString()
    sendMessage(msg, sc)
    val rec = receiveMessage(sc)
    //TODO 处理登录校验与保存context
}

/**
 * ip、port 待修改
 */
fun initConnect():Socket{
    val sc:Socket = Socket("192.168.1.1", 80) //通过socket连接服务器,参数ip为服务端ip地址，port为服务端监听端口
    sc.setSoTimeout(10000)  //设置连接超时限制
    if (sc != null) {    //判断一下是否连上，避免NullPointException
        System.out.println("connect server successful")
    } else {
        System.out.println("connect server failed,now retry...")
        initConnect()   //没连上就重试一次
    }
    return sc
}

/**
 * 发送数据至服务器
 * @param message 要发送至服务器的字符串
 */
fun sendMessage(msg: String?, sc:Socket) {
    var message = msg
    val dout =sc!!. getOutputStream()    //获取输出流
    try {
        if (dout != null && message != null) {        //判断输出流或者消息是否为空，为空的话会产生nullpoint错误
            message = "$message\n"          //末尾加上换行服务器端才有消息返回
            val me = message.toByteArray()  //基本输出流只能输出字符数组，如果要直接输出字符串要使用OutputStreamWriter
            dout!!.write(me)
            dout!!.flush()	//输出完记得刷新一下
        } else {
            System.out.println("The message to be sent is empty or have no connect")
        }
        System.out.println("send message successful")
    } catch (e: IOException) {
        System.out.println("send message to cilent failed")
        e.printStackTrace()
    }
    dout!!.close()	//用完记得关，留到最后统一关闭也可以

}

fun receiveMessage(sc: Socket): String? {
    var message: String? = ""	//先构造个字符串，避免NullPointException
    val din = InputStreamReader(sc.getInputStream(), "gb2312")  //获取输入流并转换为StreamReader，约定编码格式
    try {
        val inMessage = CharArray(1024)
        val a = din!!.read(inMessage) //a存储返回消息的长度
        if (a <= -1) {	//接受到的消息没有长度，即代表服务端发送了空的消息
            return null
        }
        message = String(inMessage, 0, a) //用string的构造方法来转换字符数组为字符串
        System.out.println("接收到："+message)
    } catch (e: IOException) {
        System.out.println("receive message failed")
        e.printStackTrace()
    }
    din!!.close()
    return message
}

