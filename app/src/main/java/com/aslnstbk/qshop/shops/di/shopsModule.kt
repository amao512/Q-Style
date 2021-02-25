package com.aslnstbk.qshop.shops.di

import com.aslnstbk.qshop.shops.data.DefaultShopsRepository
import com.aslnstbk.qshop.shops.domain.ShopsRepository
import com.aslnstbk.qshop.shops.presentation.viewModel.ShopsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val shopsModule = module {

    viewModel {
        ShopsViewModel(
            shopsRepository = get()
        )
    }

    factory {
        DefaultShopsRepository() as ShopsRepository
    }
}