package com.aslnstbk.qshop.shops.presentation.view

import android.view.View
import android.widget.TextView
import com.aslnstbk.qshop.R
import com.aslnstbk.qshop.common.domain.ImageLoader
import com.aslnstbk.qshop.common.presentation.models.ShopListItem
import com.aslnstbk.qshop.common.presentation.models.ShopsItem
import com.aslnstbk.qshop.common.presentation.view.BaseViewHolder
import com.aslnstbk.qshop.shops.data.models.Shop
import de.hdodenhof.circleimageview.CircleImageView

class ShopViewHolder(
    itemView: View,
    private val imageLoader: ImageLoader
) : BaseViewHolder<ShopListItem>(itemView) {

    private val photoCircleImageView: CircleImageView = itemView.findViewById(R.id.shop_item_photo_image_view)
    private val shopNameTextView: TextView = itemView.findViewById(R.id.shop_item_shop_name)
    private val productNameTextView: TextView = itemView.findViewById(R.id.shop_item_product_name)

    override fun onBind(data: ShopListItem) {
        val shop: Shop = (data as? ShopsItem)?.shop ?: return

        shopNameTextView.text = shop.name
        productNameTextView.text = shop.description

        imageLoader.load(
            url = shop.photoUrl,
            target = photoCircleImageView
        )
    }
}
