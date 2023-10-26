package com.soar.delicacy.repository

import com.soar.common.base.BaseApplication
import com.soar.mvi.core.FetchStatus
import com.soar.mvi.core.ViewState
import com.soar.network.bean.response.Recipes
import com.soar.network.bean.response.RecipesItem
import com.soar.network.constant.APIMain
import com.soar.network.retrofit.RetrofitClient
import com.soar.network.utils.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * NAME：YONG_
 * Created at: 2023/9/6 10
 * Describe:
 */
object RecipesListRepository {

    fun requestRecipes(): Flow<ViewState<Recipes>> {
        return flow {
            emit(exRequestRecipes())
        }.flowOn(Dispatchers.IO)
    }

    private suspend fun exRequestRecipes(): ViewState<Recipes> {
        if (!NetworkUtils.isNetworkConnected(BaseApplication.context))
            return ViewState(FetchStatus.Error(-1))

        val fetchRecipes = RetrofitClient.getApi(APIMain.API_HF)!!.fetchRecipes()
        if (fetchRecipes.isSuccessful)
            return ViewState(FetchStatus.Fetched,Recipes(fetchRecipes.body() as ArrayList<RecipesItem>))
        else
            return ViewState(FetchStatus.Error(fetchRecipes.code()))
    }
}