package com.example.domain.source

import com.example.domain.model.ItemCoin

interface ItemCoinDataSource {
    suspend fun getAllCoins(currency: String): List<ItemCoin>
}