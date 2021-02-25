package com.aslnstbk.qshop.products.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aslnstbk.qshop.common.presentation.models.ProductsItem
import com.aslnstbk.qshop.common.presentation.models.ShopListItem
import com.aslnstbk.qshop.products.domain.ProductsRepository
import com.aslnstbk.qshop.products.models.Product

class ProductsViewModel(
    private val productsRepository: ProductsRepository
) : ViewModel() {

    private val _productsLiveData: MutableLiveData<List<ShopListItem>> = MutableLiveData()

    val productsLiveData: LiveData<List<ShopListItem>> = _productsLiveData

    fun onStart() {
        loadProducts()
    }

    private fun loadProducts() {
        productsRepository.loadProductsList(
            result = {
                _productsLiveData.value = prepareProductsList(it)
            },
            fail = {}
        )
    }

    private fun prepareProductsList(productsList: List<Product>): List<ShopListItem>? {
        return productsList.map {
            ProductsItem(product = it)
        }
    }
}