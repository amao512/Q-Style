package com.aslnstbk.qshop.common.presentation.models

import com.aslnstbk.qshop.basket.data.models.Basket
import com.aslnstbk.qshop.products.models.Product
import com.aslnstbk.qshop.shops.data.models.Shop

const val SHOPS_TYPE = 0
const val PRODUCTS_TYPE = 1
const val BASKET_TYPE = 2

sealed class ShopListItem(
    val type: Int
)

data class ShopsItem(
    val shop: Shop
) : ShopListItem(SHOPS_TYPE)

data class ProductsItem(
    val product: Product
) : ShopListItem(PRODUCTS_TYPE)

data class BasketItem(
    val basket: Basket
) : ShopListItem(BASKET_TYPE)