package com.example.presentations.main

import com.example.presentations.di.CoinDataSourceModule
import com.example.presentations.di.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, CoinDataSourceModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}
