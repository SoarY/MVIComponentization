package com.soar.sign.activity

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.soar.common.router.RouteConstants

/**
 * NAME：YONG_
 * Created at: 2023/8/24 16
 * Describe:
 */
class SplashActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        Handler().postDelayed({
            ARouter.getInstance()
                .build(RouteConstants.Sign.SIGN_LOGIN)
                .navigation(this)
            finish()
        }, DELAY_MILLIS)
    }

    companion object {
        val DELAY_MILLIS=3000L
    }
}