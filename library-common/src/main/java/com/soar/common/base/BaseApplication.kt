package com.soar.common.base

import android.app.Application
import android.content.Context

/**
 * NAME：YONG_
 * Created at: 2023/8/24 16
 * Describe:
 */
open class BaseApplication :Application(){

    companion object{
        lateinit var context: Context
        lateinit var instance:Application
    }


    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        instance = this
        context = getApplicationContext()
    }
}