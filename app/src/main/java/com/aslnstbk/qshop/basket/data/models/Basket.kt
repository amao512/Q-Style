package com.aslnstbk.qshop.basket.data.models

data class Basket(
    val id: String,
    val photoUrl: String,
    val shopName: String,
    val productName: String,
    var isDelivered: Boolean = true
)