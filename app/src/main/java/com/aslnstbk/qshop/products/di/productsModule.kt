package com.aslnstbk.qshop.products.di

import com.aslnstbk.qshop.products.data.DefaultProductsRepository
import com.aslnstbk.qshop.products.domain.ProductsRepository
import com.aslnstbk.qshop.products.presentation.viewModel.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val productsModule = module {

    viewModel {
        ProductsViewModel(
            productsRepository = get()
        )
    }

    factory {
        DefaultProductsRepository() as ProductsRepository
    }
}