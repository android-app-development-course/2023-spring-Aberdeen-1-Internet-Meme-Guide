package com.example.forumapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {
    init {
        Log.i("UserViewModel","UsVMd created.")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("UserViewModel","UsVMd cleared.")
    }


}