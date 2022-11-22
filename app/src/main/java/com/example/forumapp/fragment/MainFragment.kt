package com.example.forumapp.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.forumapp.ArticleEditActivity
import com.example.forumapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainFragment:NavHostFragment() {


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_main, container, false)

        val bottomNavi = view.findViewById<BottomNavigationView>(R.id.mainNavi)
        bottomNavi.setOnItemSelectedListener {
                item ->
            when(item.itemId){
                R.id.newsNaviBtn -> {
                    replaceComponent(NewsFragment())
                    true
                }
                R.id.passageNaviBtn -> {
                    // TODO: 加路由
                    replaceComponent(PostFragment())
                    true
                }
                R.id.postNaviBtn -> {
                    // TODO: 加路由
                    true
                }
                R.id.myNaviBtn -> {
                    // TODO: 加路由
                    findNavController().navigate(R.navigation.nav_graph)
                    true
                }
                else -> false
            }
        }

        val postBtn=view.findViewById<FloatingActionButton>(R.id.postNaviBtn)
        postBtn.setOnClickListener{
            // TODO
            val intent = Intent(activity, ArticleEditActivity::class.java)
            startActivity(intent)

        }
        return view
    }

    override fun onStart() {
        super.onStart()
        initFragment()
    }

    private fun initFragment() {
        val fragmentManager = childFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.mainArea,NewsFragment())
        transaction.commit()
    }

    private fun replaceComponent(fragment: Fragment) {
//        if (!token){
//            val navController = findNavController()
//            navController.navigate(LoginFragment)
//        }
        val fragmentManager = childFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.mainArea,fragment)
        transaction.commit()
    }


}