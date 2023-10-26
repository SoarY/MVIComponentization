package com.soar.sign.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.soar.common.router.RouteConstants
import com.soar.mvi.base.BaseActivity
import com.soar.mvi.core.FetchStatus
import com.soar.mvi.core.ViewState
import com.soar.network.bean.response.LoginResponse
import com.soar.sign.action.LoginViewAction
import com.soar.sign.databinding.SignActivityLoginBinding
import com.soar.sign.vm.LoginViewModel

/**
 * NAME：YONG_
 * Created at: 2023/8/24 17
 * Describe:
 */
@Route(path = RouteConstants.Sign.SIGN_LOGIN)
class LoginActivity : BaseActivity<SignActivityLoginBinding>(){

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        binding.login.setOnClickListener {
            loginViewModel.dispatch(
                LoginViewAction.LoginClicked(binding.username.text.trim().toString(),
                    binding.password.text.toString()))
        }
    }

    fun observeViewModel() {
        loginViewModel.viewStates.observe(this, ::handleLoginResult)
    }

    private fun handleLoginResult(status: ViewState<LoginResponse>) {
        Log.i(TAG, "handleLoginResult: $status")
        when (status.fetchStatus) {
            is FetchStatus.Fetching -> binding.loaderView.visibility= View.VISIBLE
            is FetchStatus.Fetched -> status.data?.let {
                binding.loaderView.visibility= View.GONE
                ARouter.getInstance()
                    .build(RouteConstants.Delicacy.DELICACY_RECIPES)
                    .navigation(this)
                finish()
            }
            is FetchStatus.Error -> {
                binding.loaderView.visibility= View.GONE
                (status.fetchStatus as FetchStatus.Error).errorCode.let {
                    Log.i(TAG, "handleLoginResult: $status.errorCode")
                }
            }
            is FetchStatus.NotFetched -> {
            }
        }
    }
}