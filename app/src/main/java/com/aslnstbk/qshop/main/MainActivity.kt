package com.aslnstbk.qshop.main

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.aslnstbk.qshop.R
import com.aslnstbk.qshop.common.domain.ImageLoader
import com.aslnstbk.qshop.q_shop.QShopFragment
import com.google.android.material.navigation.NavigationView
import de.hdodenhof.circleimageview.CircleImageView
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val imageLoader: ImageLoader by inject()

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navigationView: NavigationView
    private lateinit var navHeaderView: View
    private lateinit var navHeaderPhotoCircleImageView: CircleImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initDrawer()
        selectNavigationDrawerItem()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        return true
    }

    private fun initViews() {
        drawerLayout = findViewById(R.id.activity_main_drawer_layout)
        toolbar = findViewById(R.id.activity_main_toolbar)
        navigationView = findViewById(R.id.activity_main_navigation_view)
        navHeaderView = navigationView.getHeaderView(0)
        navHeaderPhotoCircleImageView = navHeaderView.findViewById(R.id.nav_header_photo_image_view)

        imageLoader.load(
            url = "https://www.mantruckandbus.com/fileadmin/media/bilder/02_19/219_05_busbusiness_interviewHeader_1485x1254.jpg",
            target = navHeaderPhotoCircleImageView
        )

        replaceFragment(QShopFragment())
    }

    private fun initDrawer() {
        setSupportActionBar(toolbar)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

    private fun selectNavigationDrawerItem() {
        navigationView.setCheckedItem(R.id.navigation_drawer_menu_q_shop)

        navigationView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawer(GravityCompat.START)

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.activity_main_fragment_container, fragment)
            .commit()
    }
}