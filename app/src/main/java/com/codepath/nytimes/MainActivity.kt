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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // define var to manage fragments
        val fragmentManager: FragmentManager = supportFragmentManager

        // define fragments
        val homeFragment: Fragment = HomeFragment()
        val bestSellerBooksFragment: Fragment = BestSellerBooksFragment()
        val articleResultFragment: Fragment = ArticleResultFragment()
        val settingsFragment: Fragment = SettingsFragment()

        // define var to hold the bottom navigation view
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation_view)

        // handle navigation selection
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.action_home -> fragment = homeFragment
                R.id.action_best_selling_books -> fragment = bestSellerBooksFragment
                R.id.action_search_articles -> fragment = articleResultFragment
                R.id.action_settings -> fragment = settingsFragment

                else -> {  // set default selection
                    bottomNavigationView.selectedItemId = R.id.action_home
                }
            }

            // do a fragment transaction when the navigation item is clicked
            fragmentManager.beginTransaction().replace(R.id.fl_fragment_holder, fragment).commit()
            true
        }

    }
}
