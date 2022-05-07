package com.example.domain.model

data class ItemCoin(
    val id: String,
    val name: String,
    val symbol: String,
    val image: String,
    val price: Double,
    val priceChangePercent: Double
)
