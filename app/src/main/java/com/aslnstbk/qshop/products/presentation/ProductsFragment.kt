package com.aslnstbk.qshop.products.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.aslnstbk.qshop.R
import com.aslnstbk.qshop.common.domain.ImageLoader
import com.aslnstbk.qshop.common.presentation.models.ShopListItem
import com.aslnstbk.qshop.common.presentation.view.ShopAdapter
import com.aslnstbk.qshop.products.presentation.view.SpaceItemDecoration
import com.aslnstbk.qshop.products.presentation.viewModel.ProductsViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductsFragment : Fragment() {

    private val productsViewModel: ProductsViewModel by viewModel()
    private val imageLoader: ImageLoader by inject()

    private val shopAdapter: ShopAdapter by lazy {
        ShopAdapter(imageLoader = imageLoader)
    }

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_products, container, false)

        productsViewModel.onStart()

        initViews(view)
        observeLiveData()

        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.fragment_products_recycler_view)
        recyclerView.adapter = shopAdapter
        recyclerView.addItemDecoration(
            SpaceItemDecoration(resources.getDimensionPixelSize(R.dimen.margin_size_4x))
        )
    }

    private fun observeLiveData() {
        productsViewModel.productsLiveData.observe(viewLifecycleOwner, ::handleProducts)
    }

    private fun handleProducts(list: List<ShopListItem>) {
        shopAdapter.setList(list)
    }
}