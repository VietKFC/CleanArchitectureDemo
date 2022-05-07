package com.example.data.api.dao

import com.example.data.entity.ItemCoinEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("coins/markets")
    suspend fun getAllCoins(@Query("vs_currency") currency: String): List<ItemCoinEntity>
}
