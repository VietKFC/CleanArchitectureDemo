package com.example.presentations.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.presentations.databinding.ActivityMainBinding
import com.example.presentations.di.CoinDataSourceModule
import com.example.presentations.di.NetworkModule
import com.example.presentations.viewmodel.ListCoinViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @Inject
    lateinit var viewModel: ListCoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        DaggerMainComponent.builder()
            .networkModule(NetworkModule(applicationContext))
            .coinDataSourceModule(CoinDataSourceModule())
            .build()
            .inject(this)

        initObservers()
        viewModel.getItemCoins("usd")
    }

    private fun initObservers() {
        viewModel.itemCoins.observe(this, {
        })
    }
}
