package com.example.domain.repository

import com.example.domain.model.ItemCoin

interface ItemCoinRepository {
    suspend fun getAllCoins(currency: String): List<ItemCoin>
}
