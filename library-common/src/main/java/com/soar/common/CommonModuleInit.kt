package com.soar.common

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.soar.common.imp.IModuleInit

/**
 * NAME：YONG_
 * Created at: 2023/8/24 17
 * Describe:
 */
class CommonModuleInit : IModuleInit{

    override fun onInitAhead(application: Application?): Boolean {
        //初始化阿里路由框架
        if (BuildConfig.DEBUG) {
            ARouter.openLog() // 打印日志
            ARouter.openDebug() // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application) // 尽可能早，推荐在Application中初始化
       return false
    }

    override fun onInitLow(application: Application?): Boolean {
        return false
    }
}