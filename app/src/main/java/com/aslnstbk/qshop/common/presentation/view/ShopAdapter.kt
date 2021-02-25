package com.aslnstbk.qshop.common.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aslnstbk.qshop.R
import com.aslnstbk.qshop.basket.presentation.view.BasketViewHolder
import com.aslnstbk.qshop.common.domain.ImageLoader
import com.aslnstbk.qshop.common.presentation.models.PRODUCTS_TYPE
import com.aslnstbk.qshop.common.presentation.models.SHOPS_TYPE
import com.aslnstbk.qshop.common.presentation.models.ShopListItem
import com.aslnstbk.qshop.products.presentation.view.ProductsViewHolder
import com.aslnstbk.qshop.shops.presentation.view.ShopViewHolder

class ShopAdapter(
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<BaseViewHolder<ShopListItem>>() {

    private val shopListItemList: MutableList<ShopListItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ShopListItem> {
        return when (viewType) {
            SHOPS_TYPE -> createShopViewHolder(parent)
            PRODUCTS_TYPE -> createProductsViewHolder(parent)
            else -> createBasketViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ShopListItem>, position: Int) {
        holder.onBind(shopListItemList[position])
    }

    override fun getItemCount(): Int = shopListItemList.size

    override fun getItemViewType(position: Int): Int = shopListItemList[position].type

    fun setList(shopListItemList: List<ShopListItem>) {
        this.shopListItemList.clear()
        this.shopListItemList.addAll(shopListItemList)
        notifyDataSetChanged()
    }

    private fun createShopViewHolder(parent: ViewGroup): BaseViewHolder<ShopListItem> {
        return ShopViewHolder(
            inflateView(parent, R.layout.shop_item),
            imageLoader
        )
    }

    private fun createProductsViewHolder(parent: ViewGroup): BaseViewHolder<ShopListItem> {
        return ProductsViewHolder(
            inflateView(parent, R.layout.product_item),
            imageLoader
        )
    }

    private fun createBasketViewHolder(parent: ViewGroup): BaseViewHolder<ShopListItem> {
        return BasketViewHolder(
            inflateView(parent, R.layout.basket_item),
            imageLoader
        )
    }

    private fun inflateView(parent: ViewGroup, itemView: Int): View {
        return LayoutInflater.from(parent.context).inflate(
            itemView,
            parent,
            false
        )
    }
}