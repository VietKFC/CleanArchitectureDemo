package com.example.data.repository

import com.example.domain.repository.ItemCoinRepository
import com.example.domain.source.ItemCoinDataSource

class ItemCoinRepositoryImpl(
    private val remote: ItemCoinDataSource
) : ItemCoinRepository {
    override suspend fun getAllCoins(currency: String) = remote.getAllCoins(currency)
}
