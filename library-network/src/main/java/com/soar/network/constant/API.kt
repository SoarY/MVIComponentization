package com.soar.network.constant


import com.soar.network.bean.response.RecipesItem
import retrofit2.Response
import retrofit2.http.GET

/**
 * YONG_
 */
interface API {
    @GET("recipes.json")
    suspend fun fetchRecipes(): Response<List<RecipesItem>>
}