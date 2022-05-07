package com.example.data.entity

import com.google.gson.annotations.SerializedName

data class ItemCoinEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("current_price")
    val price: Double,
    @SerializedName("price_change_percentage_24h")
    val priceChangePercent: Double
)
