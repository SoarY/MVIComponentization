package com.soar.common.router

/**
 * NAME：YONG_
 * Created at: 2023/3/23 18
 * Describe:
 */
open class RouteConstants {
    /**
     * 身份验证组件
     */
    open class Sign {
        companion object {
            const val SIGN = "/sign"
            //登录界面
            const val SIGN_LOGIN = "$SIGN/login"
        }
    }

    /**
     * 用户组件
     */
    open class Delicacy {
        companion object {
            const val DELICACY = "/delicacy"
            //食谱列表
            const val DELICACY_RECIPES = "$DELICACY/recipes"
            //食谱详情
            const val DELICACY_DETAILS = "$DELICACY/details"
        }
    }
}