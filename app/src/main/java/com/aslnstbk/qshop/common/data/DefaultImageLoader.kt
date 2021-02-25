package com.aslnstbk.qshop.common.data

import android.widget.ImageView
import com.aslnstbk.qshop.common.domain.ImageLoader
import com.bumptech.glide.Glide

class DefaultImageLoader : ImageLoader {

    override fun load(
        url: String,
        target: ImageView
    ) {
        Glide.with(target.context)
            .load(url)
            .fitCenter()
            .into(target)
    }
}