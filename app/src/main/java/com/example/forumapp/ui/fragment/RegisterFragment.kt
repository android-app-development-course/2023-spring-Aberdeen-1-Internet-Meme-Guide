package com.example.forumapp.ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.forumapp.R
import com.example.forumapp.services.UserRepository
import org.xutils.http.RequestParams

class RegisterFragment: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        return view
    }

    suspend fun doRegister(email:String, password:String){
        val repository = UserRepository()
        val data = RequestParams()
        data.addBodyParameter("email",email)
        data.addBodyParameter("password",password)
        repository.register(data)
        return
    }
}
