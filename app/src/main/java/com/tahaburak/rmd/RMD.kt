package com.tahaburak.rmd

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.app.Application
import android.content.Context

/**
 * Created by burak on 23.02.2022
 */
class RMD : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var instance: RMD
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    var mCurrentActivity: Activity? = null
    fun isInForeground(): Boolean {
        val activityManager = instance.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val runningAppProcesses = activityManager.runningAppProcesses ?: return false
        return runningAppProcesses.any { it.processName == instance.packageName && it.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND }
    }
}