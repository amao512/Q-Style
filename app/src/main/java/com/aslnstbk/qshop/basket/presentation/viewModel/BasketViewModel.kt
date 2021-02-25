package com.aslnstbk.qshop.basket.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aslnstbk.qshop.basket.data.models.Basket
import com.aslnstbk.qshop.basket.domain.BasketRepository
import com.aslnstbk.qshop.common.presentation.models.BasketItem
import com.aslnstbk.qshop.common.presentation.models.ShopListItem

class BasketViewModel(
    private val basketRepository: BasketRepository
) : ViewModel() {

    private val _basketLiveData: MutableLiveData<List<ShopListItem>> = MutableLiveData()

    val basketLiveData: LiveData<List<ShopListItem>> = _basketLiveData

    fun onStart() {
        loadBasketList()
    }

    private fun loadBasketList() {
        basketRepository.loadBasketList(
            result = {
                _basketLiveData.value = prepareBasketList(it)
            },
            fail = {}
        )
    }

    private fun prepareBasketList(basketList: List<Basket>): List<ShopListItem>? {
        return basketList.map {
            BasketItem(basket = it)
        }
    }
}