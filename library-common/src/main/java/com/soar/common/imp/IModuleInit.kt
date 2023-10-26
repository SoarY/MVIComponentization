package com.soar.common.imp

import android.app.Application

/**
 * NAME：YONG_
 * Created at: 2023/8/24 17
 * Describe:
 */
interface IModuleInit {
    //初始化优先的
    fun onInitAhead(application: Application?): Boolean

    //初始化靠后的
    fun onInitLow(application: Application?): Boolean
}