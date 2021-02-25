package com.aslnstbk.qshop.di

import com.aslnstbk.qshop.common.data.DefaultImageLoader
import com.aslnstbk.qshop.common.domain.ImageLoader
import org.koin.dsl.module

val applicationModule = module {

    factory {
        DefaultImageLoader() as ImageLoader
    }
}