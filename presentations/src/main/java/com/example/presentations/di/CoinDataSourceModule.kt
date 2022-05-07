package com.example.presentations.di

import com.example.data.api.dao.ApiService
import com.example.domain.repository.ItemCoinRepository
import com.example.data.repository.ItemCoinRepositoryImpl
import com.example.data.entity.mapper.ItemCoinMapper
import com.example.domain.source.ItemCoinDataSource
import com.example.data.source.ItemCoinRemoteDataSource
import com.example.domain.usecase.GetListCoinUseCase
import com.example.presentations.viewmodel.ListCoinViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoinDataSourceModule {

    @Provides
    @Singleton
    fun provideItemCoinMapper() = ItemCoinMapper()

    @Provides
    @Singleton
    fun provideListCoinRemoteDataSource(
        apiService: ApiService,
        modelMapper: ItemCoinMapper
    ): ItemCoinDataSource {
        return ItemCoinRemoteDataSource(apiService, modelMapper)
    }

    @Provides
    @Singleton
    fun provideListCoinRepository(itemCoinDataSource: ItemCoinDataSource): ItemCoinRepository {
        return ItemCoinRepositoryImpl(itemCoinDataSource)
    }

    @Provides
    @Singleton
    fun provideGetListCoinUseCase(itemCoinRepository: ItemCoinRepository): GetListCoinUseCase {
        return GetListCoinUseCase(itemCoinRepository)
    }

    @Provides
    @Singleton
    fun provideListCoinViewModel(getListCoinUseCase: GetListCoinUseCase): ListCoinViewModel {
        return ListCoinViewModel(getListCoinUseCase)
    }
}