package com.aslnstbk.qshop.q_shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aslnstbk.qshop.R
import com.aslnstbk.qshop.basket.presentation.BasketFragment
import com.aslnstbk.qshop.products.presentation.ProductsFragment
import com.aslnstbk.qshop.shops.presentation.ShopsFragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation

class QShopFragment : Fragment() {

    private lateinit var meowBottomNavigationView: MeowBottomNavigation

    private lateinit var shopsFragment: ShopsFragment
    private lateinit var productsFragment: ProductsFragment
    private lateinit var basketFragment: BasketFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_q_shop, container, false)

        initViews(view)
        selectBottomNavigationItem()

        return view
    }

    private fun initViews(view: View) {
        meowBottomNavigationView = view.findViewById(R.id.fragment_q_shop_meow_bottom_navigation_view)

        shopsFragment = ShopsFragment()
        productsFragment = ProductsFragment()
        basketFragment = BasketFragment()
    }

    private fun selectBottomNavigationItem() {
        replaceFragment(
            fragment = ShopsFragment(),
            isBackStack = false
        )

        meowBottomNavigationView.add(MeowBottomNavigation.Model(0, R.drawable.ic_shopping_cart))
        meowBottomNavigationView.add(MeowBottomNavigation.Model(1, R.drawable.ic_shop))
        meowBottomNavigationView.add(MeowBottomNavigation.Model(2, R.drawable.ic_shopping_basket))
        meowBottomNavigationView.show(0)

        meowBottomNavigationView.setOnClickMenuListener {
            when (it.id) {
                0 -> replaceFragment(shopsFragment)
                1 -> replaceFragment(productsFragment)
                2 -> replaceFragment(basketFragment)
            }
        }
    }

    private fun replaceFragment(
        fragment: Fragment,
        isBackStack: Boolean = true
    ) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragment_q_shop_fragment_container, fragment)
            if (isBackStack) {
                addToBackStack(null)
            }
            commit()
        }
    }
}