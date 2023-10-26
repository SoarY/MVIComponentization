package com.soar.sign.action

/**
 * NAME：YONG_
 * Created at: 2023/10/26 11
 * Describe:
 */
sealed class LoginViewAction {
    data class LoginClicked(val username: String,val password: String): LoginViewAction()
}
