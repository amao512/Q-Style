package com.aslnstbk.qshop.products.domain

import com.aslnstbk.qshop.products.models.Product

interface ProductsRepository {

    fun loadProductsList(
        result: (List<Product>) -> Unit,
        fail: (String) -> Unit
    )
}