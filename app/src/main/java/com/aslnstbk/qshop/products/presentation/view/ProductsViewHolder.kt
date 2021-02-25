package com.aslnstbk.qshop.products.presentation.view

import android.view.View
import android.widget.TextView
import com.aslnstbk.qshop.R
import com.aslnstbk.qshop.common.domain.ImageLoader
import com.aslnstbk.qshop.common.presentation.models.ProductsItem
import com.aslnstbk.qshop.common.presentation.models.ShopListItem
import com.aslnstbk.qshop.common.presentation.view.BaseViewHolder
import com.aslnstbk.qshop.products.models.Product
import de.hdodenhof.circleimageview.CircleImageView

class ProductsViewHolder(
    itemView: View,
    private val imageLoader: ImageLoader
) : BaseViewHolder<ShopListItem>(itemView) {

    private val photoCircleImageView: CircleImageView = itemView.findViewById(R.id.product_item_photo_image_view)
    private val shopNameTextView: TextView = itemView.findViewById(R.id.product_item_shop_name)
    private val productNameTextView: TextView = itemView.findViewById(R.id.product_item_product_name)

    override fun onBind(data: ShopListItem) {
        val product: Product = (data as? ProductsItem)?.product ?: return

        shopNameTextView.text = product.shopName
        productNameTextView.text = product.productName

        imageLoader.load(
            url = product.photoUrl,
            target = photoCircleImageView
        )
    }
}
