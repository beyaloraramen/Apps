package com.ramen.apps

import android.app.Application
import android.util.Log
import com.ramen.apps.utils.showError

class RamenApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val dueh = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            try {
                showError(Log.getStackTraceString(throwable))
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                dueh?.uncaughtException(thread, throwable)
            }
        }
    }
}
