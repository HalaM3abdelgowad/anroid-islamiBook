package com.route.islamibook.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.route.islamibook.R
import com.route.islamibook.ui.home.fragments.HadethFragment
import com.route.islamibook.ui.home.fragments.QuranFragment
import com.route.islamibook.ui.home.fragments.RadioFragment
import com.route.islamibook.ui.home.fragments.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigation = findViewById(R.id.bottom_navigation_bar)

        /// click on bottom navigation
        bottomNavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {

                menuItem ->
            if (menuItem.itemId == R.id.navigation_quran) {
                pushFragment(QuranFragment())


            } else if (menuItem.itemId == R.id.navigation_hadeth) {
                pushFragment(HadethFragment())


            } else if (menuItem.itemId == R.id.navigation_sebha) {
                pushFragment(TasbehFragment())

            } else if (menuItem.itemId == R.id.navigation_radio) {
                pushFragment(RadioFragment())
            }
            return@OnItemSelectedListener true
        })

        // for make quran item selected and apper fist app opened

        bottomNavigation.selectedItemId = R.id.navigation_quran
    }

    /// for push fragment
    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}