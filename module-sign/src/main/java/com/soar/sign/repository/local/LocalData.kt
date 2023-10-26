package com.soar.sign.repository.local

import com.soar.network.bean.request.LoginRequest
import com.soar.network.bean.response.LoginResponse
import com.soar.mvi.core.FetchStatus
import com.soar.mvi.core.ViewState

object LocalData{

    fun doLogin(loginRequest: LoginRequest): ViewState<LoginResponse> {
        if (loginRequest == LoginRequest("ahmed@ahmed.ahmed", "ahmed")) {
            return ViewState(
                FetchStatus.Fetched,LoginResponse("123", "Ahmed", "Mahmoud",
                    "FrunkfurterAlle", "77", "12000", "Berlin",
                    "Germany", "ahmed@ahmed.ahmed"))
        }
        return ViewState(FetchStatus.Error(-1101))
    }
}

