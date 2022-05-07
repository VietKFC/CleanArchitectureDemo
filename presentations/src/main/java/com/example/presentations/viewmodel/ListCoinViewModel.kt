package com.example.presentations.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ItemCoin
import com.example.domain.usecase.GetListCoinUseCase
import com.example.presentations.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListCoinViewModel @Inject constructor(
    private val getListCoinUseCase: GetListCoinUseCase
) : BaseViewModel() {

    private val _itemCoins = MutableLiveData<List<ItemCoin>>()
    val itemCoins: LiveData<List<ItemCoin>> get() = _itemCoins

    fun getItemCoins(currency: String) {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            getListCoinUseCase.invoke(currency).also { _itemCoins.postValue(it) }
        }
    }
}
