package com.example.data.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class InterceptorImpl : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = initHeader(chain)
        return chain.proceed(requestBuilder.build())
    }

    private fun initHeader(chain: Interceptor.Chain): Request.Builder {
        val request = chain.request()
        return request.newBuilder()
            .method(request.method, request.body)
    }
}
