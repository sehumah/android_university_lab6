package com.codepath.nytimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.codepath.nytimes.ui.books.BestSellerBooksFragment
import com.codepath.nytimes.ui.home.HomeFragment
import com.codepath.nytimes.ui.search.ArticleResultFragment
import com.codepath.nytimes.ui.settings.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // define fragments
    private val homeFragment: Fragment = HomeFragment()
    private val bestSellerBooksFragment: Fragment = BestSellerBooksFragment()
    private val articleResultFragment: Fragment = ArticleResultFragment()
    private val settingsFragment: Fragment = SettingsFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // define var to hold the bottom navigation view
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation_view)

        // handle navigation selection
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

    /*
    // add menu items to the action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // inflate the menu; this adds items to the action bar if it is present
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    */
}
