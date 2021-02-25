package com.aslnstbk.qshop.basket.domain

import com.aslnstbk.qshop.basket.data.models.Basket

interface BasketRepository {

    fun loadBasketList(
        result: (List<Basket>) -> Unit,
        fail: (String) -> Unit
    )
}