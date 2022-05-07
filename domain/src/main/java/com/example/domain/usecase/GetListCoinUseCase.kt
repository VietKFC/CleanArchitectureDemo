package com.example.domain.usecase

import com.example.domain.model.ItemCoin
import com.example.domain.repository.ItemCoinRepository
import javax.inject.Inject

class GetListCoinUseCase @Inject constructor(
    private val itemCoinRepository: ItemCoinRepository
){
    suspend fun invoke(currency: String): List<ItemCoin> = itemCoinRepository.getAllCoins(currency)
}
