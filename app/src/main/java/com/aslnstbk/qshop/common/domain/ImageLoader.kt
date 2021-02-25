package com.aslnstbk.qshop.common.domain

import android.widget.ImageView

interface ImageLoader {

    fun load(
        url: String,
        target: ImageView
    )
}