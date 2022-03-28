package com.codepath.nytimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.codepath.nytimes.ui.books.BestSellerBooksFragment
import com.codepath.nytimes.ui.home.HomeFragment
import com.codepath.nytimes.ui.search.ArticleResultFragment
import com.codepath.nytimes.ui.settings.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    // define fragments
    private var homeFragment: Fragment = HomeFragment()
    private var bestSellerBooksFragment: Fragment = BestSellerBooksFragment()
    private var articleResultFragment: Fragment = ArticleResultFragment()
    private var settingsFragment: Fragment = SettingsFragment()
    private lateinit var bottomNavigationView: BottomNavigationView  // declare var to hold the bottom navigation view
    private val SELECTED_ITEM_KEY = "SomeValueToSave"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation_view)

        // handle bottom navigation selection/clicks
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val fragmentManager: FragmentManager = supportFragmentManager
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.action_bottom_nav_home -> {
                    fragment = homeFragment
                }
                R.id.action_bottom_nav_best_selling_books -> {
                    fragment = bestSellerBooksFragment
                }
                R.id.action_bottom_nav_search_articles -> {
                    fragment = articleResultFragment
                }
                R.id.action_bottom_nav_settings -> {
                    fragment = settingsFragment
                }
                else -> {  // set default selection
                    bottomNavigationView.selectedItemId = R.id.action_bottom_nav_home
                }
            }

            // do a fragment transaction when the navigation item is clicked
            fragmentManager.beginTransaction().replace(R.id.fl_fragment_holder, fragment).commit()
            true
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SELECTED_ITEM_KEY, bottomNavigationView.selectedItemId)
        super.onSaveInstanceState(outState)
    }
}
