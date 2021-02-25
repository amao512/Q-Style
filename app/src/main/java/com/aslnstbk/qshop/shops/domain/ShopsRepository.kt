package com.aslnstbk.qshop.shops.domain

import com.aslnstbk.qshop.shops.data.models.Shop

interface ShopsRepository {

    fun loadShopList(
        result: (List<Shop>) -> Unit,
        fail: (String) -> Unit
    )
}