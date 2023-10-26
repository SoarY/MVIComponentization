package com.soar.network.retrofit

import com.soar.network.constant.API
import com.soar.network.constant.APIMain
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * NAME：YONG_
 * Created at: 2023/3/29 14
 * Describe:
 */
object RetrofitClient {

    private val apis: HashMap<String, API> = HashMap()


    fun getApi(): API? {
        return getApi(APIMain.API_HF)
    }

    fun getApi(urlMain: String): API? {
        if (!apis.containsKey(urlMain)) {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(urlMain)
                .build()
            val api = retrofit.create(API::class.java)
            apis[urlMain] = api
        }
        return apis[urlMain]
    }
}