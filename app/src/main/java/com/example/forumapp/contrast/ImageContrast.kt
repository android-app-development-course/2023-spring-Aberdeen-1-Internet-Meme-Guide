package com.example.forumapp.contrast

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContract

class MultipleImageContrast : ActivityResultContract<Unit?, Uri?>(){
    override fun createIntent(context: Context, input: Unit?): Intent {
        TODO("Not yet implemented")
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
        TODO("Not yet implemented")
    }
}