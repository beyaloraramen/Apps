package com.ramen.apps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ramen.apps.ui.debug.DebugScreen
import com.ramen.apps.ui.theme.AppTheme

class DebugActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val error = intent?.getStringExtra("error")
        setContent {
            AppTheme {
                DebugScreen(error = error)
            }
        }
    }
}