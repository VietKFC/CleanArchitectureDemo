package com.example.presentations.di

import android.content.Context
import com.example.data.api.InterceptorImpl
import com.example.data.api.ServiceGenerator
import com.example.data.api.dao.ApiService
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import javax.inject.Inject
import javax.inject.Singleton

@Module
class NetworkModule @Inject constructor(
    private val context: Context
) {

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        return InterceptorImpl()
    }

    @Provides
    @Singleton
    fun provideServiceGenerator(interceptor: Interceptor): ServiceGenerator {
        return ServiceGenerator(interceptor, context)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().let {
            it.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            it.create()
        }
    }

    @Provides
    @Singleton
    fun provideApiService(serviceGenerator: ServiceGenerator, gson: Gson): ApiService {
        return serviceGenerator.apiService(gson)
    }
}