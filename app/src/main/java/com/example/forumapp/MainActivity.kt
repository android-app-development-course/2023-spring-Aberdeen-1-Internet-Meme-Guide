package com.example.forumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.NavHostFragment
import com.example.forumapp.fragment.MainFragment
import com.example.forumapp.fragment.NewsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)  // 放在setContentView之前
        setContentView(R.layout.activity_main)
        initFragment()

//        replaceContent(NewsFragment()) // 默认打开新闻页
//        NavigationBarView.OnItemSelectedListener { item ->
//            when(item.itemId){
//                R.id.newsNaviBtn -> {
//                    replaceContent(NewsFragment())
//                    true
//                }
//                R.id.passageNaviBtn -> {
//                    // TODO: 加路由
//
//                    true
//                }
//                R.id.postNaviBtn -> {
//                    // TODO: 加路由
//                    true
//                }
//                R.id.myNaviBtn -> {
//                    // TODO: 加路由
//                    true
//                }
//                else -> false
//            }
//        }
//
//        val postBtn=findViewById<FloatingActionButton>(R.id.postNaviBtn)
//        postBtn.setOnClickListener{
//            // TODO
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }
//    }
//
//    private fun replaceContent(fragment:Fragment){
//        val fragmentManager = supportFragmentManager
//        val transaction = fragmentManager.beginTransaction()
//        transaction.replace(R.id.mainArea,fragment)
//        transaction.commit()
//    }
    }

    private fun initFragment() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView,MainFragment())
        transaction.commit()
    }


}