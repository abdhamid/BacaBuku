package com.abhamid.bacabuku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.abhamid.bacabuku.ui.GenreFragment
import com.abhamid.bacabuku.ui.NewBookFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val genreFragment = GenreFragment()
    private val newBookFragment = NewBookFragment()

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragment = when(item.itemId) {
            R.id.navigation_genre -> genreFragment
            else -> newBookFragment
        }
        switchToFragment(fragment)
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_nav.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        switchToFragment(genreFragment)
    }

    private fun switchToFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment).commit()
    }




}
