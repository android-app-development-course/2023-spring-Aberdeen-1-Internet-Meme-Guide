package com.example.forumapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.forumapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainFragment:NavHostFragment() {


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
                    true
                }
                else -> false
            }
        }

        val postBtn=view.findViewById<FloatingActionButton>(R.id.postNaviBtn)
        postBtn.setOnClickListener{
            // TODO
            replaceComponent(ArticleFragment())
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