package com.soar.common.config

import android.app.Application
import com.soar.common.imp.IModuleInit

/**
 * NAME：YONG_
 * Created at: 2023/8/24 17
 * Describe:
 */
object ModuleLifecycleConfig {

    //初始化组件-靠前
    fun initModuleAhead(application: Application?) {
        for (moduleInitName in ModuleLifecycleReflex.initModuleNames) {
            try {
                val clazz = Class.forName(moduleInitName)
                val init: IModuleInit = clazz.newInstance() as IModuleInit
                //调用初始化方法
                init.onInitAhead(application)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
    }

    //初始化组件-靠后
    fun initModuleLow(application: Application?) {
        for (moduleInitName in ModuleLifecycleReflex.initModuleNames) {
            try {
                val clazz = Class.forName(moduleInitName)
                val init: IModuleInit = clazz.newInstance() as IModuleInit
                //调用初始化方法
                init.onInitLow(application)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
        }
    }
}