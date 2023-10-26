package com.soar.sign.repository

import com.soar.network.bean.request.LoginRequest
import com.soar.network.bean.response.LoginResponse
import com.soar.mvi.core.ViewState
import com.soar.sign.repository.local.LocalData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * NAME：YONG_
 * Created at: 2023/9/6 10
 * Describe:
 */
object LoginRepository {

    suspend fun doLogin(loginRequest: LoginRequest): Flow<ViewState<LoginResponse>> {
        return flow {
            emit(LocalData.doLogin(loginRequest))
        }.flowOn(Dispatchers.IO)
    }
}