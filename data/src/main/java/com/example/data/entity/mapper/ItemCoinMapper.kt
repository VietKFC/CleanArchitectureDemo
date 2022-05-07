package com.example.data.entity.mapper

import com.example.data.entity.ItemCoinEntity
import com.example.domain.model.ItemCoin
import com.example.domain.repository.mapper.ModelMapper

class ItemCoinMapper : ModelMapper.MappingToListModel<ItemCoinEntity, ItemCoin> {

    override fun fromEntities(entities: List<ItemCoinEntity>): List<ItemCoin> {
        val itemCoins = mutableListOf<ItemCoin>()
        entities.forEach {
            itemCoins.add(ItemCoin(it.id, it.name, it.symbol, it.image, it.price, it.priceChangePercent))
        }
        return itemCoins
    }

    override fun toEntities(models: List<ItemCoin>): List<ItemCoinEntity> {
        val itemCoinEntities = mutableListOf<ItemCoinEntity>()
        models.forEach {
            itemCoinEntities.add(
                ItemCoinEntity(
                    it.id, it.name, it.symbol, it.image, it.price, it.priceChangePercent
                )
            )
        }
        return itemCoinEntities
    }
}
