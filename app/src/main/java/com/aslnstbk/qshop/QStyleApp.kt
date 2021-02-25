package com.aslnstbk.qshop

import android.app.Application
import com.aslnstbk.qshop.basket.di.basketModule
import com.aslnstbk.qshop.di.applicationModule
import com.aslnstbk.qshop.products.di.productsModule
import com.aslnstbk.qshop.shops.di.shopsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class QStyleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@QStyleApp)

            modules(
                applicationModule,
                shopsModule,
                productsModule,
                basketModule
            )
        }
    }
}