package com.ramen.apps.utils

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.ramen.apps.DebugActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun Context.showError(text: String) {
    val intent = Intent(this, DebugActivity::class.java).apply {
        putExtra("error", text)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    }
    startActivity(intent)
}

suspend fun Context.showToast(text: String) {
    withContext(Dispatchers.Main) {
        Toast.makeText(this@showToast, text, Toast.LENGTH_SHORT).show()
    }
}
