package com.example.forumapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.Window
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.forumapp.ui.fragment.MainFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)  // 放在setContentView之前
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
//            checkPermission()
//        }else{
//            // todo 旧版本适配
//        }
        setContentView(R.layout.activity_main)
        initFragment()
    }

    @RequiresApi(Build.VERSION_CODES.R)
    fun checkPermission(){
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()){
                isGranted:Boolean ->
            if(isGranted){
                return@registerForActivityResult
            }else{
                // todo 提示权限缺失并返回上一页面

            }
        }

        val permissionList = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.MANAGE_EXTERNAL_STORAGE)

        for (item in permissionList){
            when{
                ContextCompat.checkSelfPermission(
                    this,
                    item
                ) == PackageManager.PERMISSION_GRANTED -> {
                    // todo
                }else -> {
                requestPermissionLauncher.launch(item)
                }
            }
        }

    }

    private fun initFragment() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView,MainFragment())
        transaction.commit()
    }




}