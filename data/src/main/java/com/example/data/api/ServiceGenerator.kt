package com.example.data.api

import android.content.Context
import com.example.data.Constant
import com.example.data.api.dao.ApiService
import com.google.gson.Gson
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ServiceGenerator @Inject constructor(
    private val interceptor: Interceptor,
    private val context: Context
) {

    fun apiService(gson: Gson) = getRetrofitBuilder(gson).create(ApiService::class.java)

    private fun getRetrofitBuilder(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(buildOkHttpClient())
            .build()
    }

    private fun buildOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.cache(getOkHttpCache(context))
        okHttpClient.addInterceptor(interceptor)
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient.addInterceptor(httpLoggingInterceptor)
        return okHttpClient.build()
    }

    private fun getOkHttpCache(context: Context) = Cache(context.cacheDir, 10 * 1024 * 1024)
}
