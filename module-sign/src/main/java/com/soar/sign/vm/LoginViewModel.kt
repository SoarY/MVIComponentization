package com.soar.sign.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.soar.mvi.base.BaseViewModel
import com.soar.mvi.core.FetchStatus
import com.soar.mvi.core.ViewState
import com.soar.network.bean.request.LoginRequest
import com.soar.network.bean.response.LoginResponse
import com.soar.sign.action.LoginViewAction
import com.soar.sign.repository.LoginRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * NAME：YONG_
 * Created at: 2023/8/24 17
 * Describe:
 */
class LoginViewModel : BaseViewModel(){

    private val _viewStates: MutableLiveData<ViewState<LoginResponse>> = MutableLiveData()
    val viewStates get() = _viewStates

    fun dispatch(viewAction: LoginViewAction) {
        when (viewAction) {
            is LoginViewAction.LoginClicked -> doLogin(viewAction.username,viewAction.password)
        }
    }

    fun doLogin(userName: String, passWord: String) {
        viewModelScope.launch {
            _viewStates.value = ViewState(FetchStatus.Fetching)
            LoginRepository.doLogin(loginRequest = LoginRequest(userName, passWord)).collect {
                _viewStates.value = it
            }
        }
    }
}