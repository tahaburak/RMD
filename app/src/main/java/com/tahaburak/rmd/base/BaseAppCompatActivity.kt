package com.tahaburak.rmd.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.tahaburak.rmd.RMD

/**
 * Created by burak on 23.02.2022
 */
open class BaseAppCompatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setAsCurrent()
    }

    override fun onStart() {
        super.onStart()
        setAsCurrent()
    }

    override fun onResume() {
        super.onResume()
        setAsCurrent()
    }

    override fun onPause() {
        super.onPause()
        removeCurrent()
    }

    override fun onStop() {
        super.onStop()
        removeCurrent()
    }

    override fun onRestart() {
        super.onRestart()
        setAsCurrent()
    }

    override fun onDestroy() {
        super.onDestroy()
        removeCurrent()
    }

    private fun setAsCurrent() {
        if (this != RMD.instance.mCurrentActivity) {
            RMD.instance.mCurrentActivity = this
        }
    }

    private fun removeCurrent() {
        if (this == RMD.instance.mCurrentActivity) {
            RMD.instance.mCurrentActivity = null
        }
    }


}