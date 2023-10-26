package com.soar.mvvmcomponentization

import com.soar.common.base.BaseApplication
import com.soar.common.config.ModuleLifecycleConfig

/**
 * NAME：YONG_
 * Created at: 2023/3/22 15
 * Describe:
 */
class AppApplication : BaseApplication(){

    override fun onCreate() {
        super.onCreate()
        //初始化组件(靠前)
        ModuleLifecycleConfig.initModuleAhead(this)
        //....
        //初始化组件(靠后)
        ModuleLifecycleConfig.initModuleLow(this)
    }

}