package com.aslnstbk.qshop.shops.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aslnstbk.qshop.common.presentation.models.ShopListItem
import com.aslnstbk.qshop.common.presentation.models.ShopsItem
import com.aslnstbk.qshop.shops.domain.ShopsRepository
import com.aslnstbk.qshop.shops.data.models.Shop

class ShopsViewModel(
    private val shopsRepository: ShopsRepository
) : ViewModel() {

    private val _shopsLiveData: MutableLiveData<List<ShopListItem>> = MutableLiveData()

    val shopsLiveData: LiveData<List<ShopListItem>> = _shopsLiveData

    fun onStart() {
        loadShopList()
    }

    private fun loadShopList() {
        shopsRepository.loadShopList(
            result = {
                _shopsLiveData.value = prepareShopList(it)
            },
            fail = {}
        )
    }

    private fun prepareShopList(shopList: List<Shop>): List<ShopListItem>? {
        return shopList.map {
            ShopsItem(shop = it)
        }
    }
}