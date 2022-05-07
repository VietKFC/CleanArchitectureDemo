package com.example.data.source

import com.example.data.api.dao.ApiService
import com.example.domain.source.ItemCoinDataSource

class ItemCoinRemoteDataSource(
    private val api: ApiService,
    private val itemCoinMapper: com.example.data.entity.mapper.ItemCoinMapper
) : ItemCoinDataSource {
    override suspend fun getAllCoins(currency: String) = itemCoinMapper.fromEntities(api.getAllCoins(currency))
}
