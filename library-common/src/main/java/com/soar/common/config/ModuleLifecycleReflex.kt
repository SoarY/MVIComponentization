package com.soar.common.config

/**
 * NAME：YONG_
 * Created at: 2023/8/24 17
 * Describe:
 */
object ModuleLifecycleReflex {

     private val CommonInit = "com.soar.common.CommonModuleInit"

     //登录验证模块
     private val SignInit = "com.soar.sign.SignModuleInit"
     //美食模块
     private val DelicacyInit = "com.soar.delicacy.DelicacyModuleInit"

     var initModuleNames = arrayOf(CommonInit, SignInit,DelicacyInit)
}