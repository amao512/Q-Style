package com.aslnstbk.qshop.basket.di

import com.aslnstbk.qshop.basket.data.DefaultBasketRepository
import com.aslnstbk.qshop.basket.domain.BasketRepository
import com.aslnstbk.qshop.basket.presentation.viewModel.BasketViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val basketModule = module {

    viewModel {
        BasketViewModel(
            basketRepository = get()
        )
    }

    factory {
        DefaultBasketRepository() as BasketRepository
    }
}