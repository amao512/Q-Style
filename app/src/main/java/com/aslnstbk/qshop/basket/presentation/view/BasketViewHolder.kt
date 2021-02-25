package com.aslnstbk.qshop.basket.presentation.view

import android.view.View
import android.widget.TextView
import com.aslnstbk.qshop.R
import com.aslnstbk.qshop.basket.data.models.Basket
import com.aslnstbk.qshop.common.domain.ImageLoader
import com.aslnstbk.qshop.common.presentation.models.BasketItem
import com.aslnstbk.qshop.common.presentation.models.ShopListItem
import com.aslnstbk.qshop.common.presentation.view.BaseViewHolder
import com.aslnstbk.qshop.utils.show
import de.hdodenhof.circleimageview.CircleImageView

class BasketViewHolder(
    itemView: View,
    private val imageLoader: ImageLoader
) : BaseViewHolder<ShopListItem>(itemView) {

    private val photoCircleImageView: CircleImageView = itemView.findViewById(R.id.basket_item_photo_image_view)
    private val shopNameTextView: TextView = itemView.findViewById(R.id.basket_item_shop_name)
    private val productNameTextView: TextView = itemView.findViewById(R.id.basket_item_product_name)
    private val deliveredStatusTextView: TextView = itemView.findViewById(R.id.basket_item_delivered_status)

    override fun onBind(data: ShopListItem) {
        val basket: Basket = (data as? BasketItem)?.basket ?: return

        shopNameTextView.text = basket.shopName
        productNameTextView.text = basket.productName

        imageLoader.load(
            url = basket.photoUrl,
            target = photoCircleImageView
        )

        if (basket.isDelivered) {
            deliveredStatusTextView.show()
        }
    }
}