package com.aslnstbk.qshop.shops.presentation

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
import com.aslnstbk.qshop.shops.presentation.viewModel.ShopsViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShopsFragment : Fragment() {

    private val shopsViewModel: ShopsViewModel by viewModel()
    private val imageLoader: ImageLoader by inject()

    private val shopAdapter: ShopAdapter by lazy {
        ShopAdapter(imageLoader = imageLoader)
    }

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_shops, container, false)

        shopsViewModel.onStart()

        initViews(view)
        observeLiveData()

        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.fragment_shops_recycler_view)
        recyclerView.adapter = shopAdapter
    }

    private fun observeLiveData() {
        shopsViewModel.shopsLiveData.observe(viewLifecycleOwner, ::handleShops)
    }

    private fun handleShops(shopsList: List<ShopListItem>) {
        shopAdapter.setList(shopsList)
    }
}