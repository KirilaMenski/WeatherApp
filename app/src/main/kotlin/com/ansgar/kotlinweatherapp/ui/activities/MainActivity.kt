package com.ansgar.kotlinweatherapp.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import com.ansgar.kotlinweatherapp.R
import com.ansgar.kotlinweatherapp.enums.FragmentEnum
import com.ansgar.kotlinweatherapp.ui.fragments.ChoiceCityFragment
import com.ansgar.kotlinweatherapp.ui.fragments.SettingsFragment
import com.ansgar.kotlinweatherapp.ui.fragments.WeatherFragment
import com.ansgar.kotlinweatherapp.utils.closeFragment
import com.ansgar.kotlinweatherapp.utils.replaceFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
        FragmentManager.OnBackStackChangedListener, View.OnClickListener, DrawerLayout.DrawerListener {

    private var mToggle: ActionBarDrawerToggle? = null
    private var mCurrentFragmentEnum: FragmentEnum? = null

    override fun onDrawerStateChanged(newState: Int) {

    }

    override fun onDrawerSlide(drawerView: View?, slideOffset: Float) {

    }

    override fun onDrawerClosed(drawerView: View?) {

        val fragment: Fragment = when (mCurrentFragmentEnum) {
            FragmentEnum.WEATHER_FRAGMENT -> WeatherFragment.newInstance(Bundle())
            FragmentEnum.CHOICE_CITY_FRAGMENT -> ChoiceCityFragment.newInstance(Bundle())
            FragmentEnum.SETTINGS_FRAGMENT -> SettingsFragment.newInstance(Bundle())
            else -> WeatherFragment()
        }

        if (mCurrentFragmentEnum != null) progress_bar_layout.visibility = View.GONE
        else return

        mCurrentFragmentEnum = null

        replaceFragment(R.id.main_fragment_container, fragment, fragment.toString(), false)

    }

    override fun onDrawerOpened(drawerView: View?) {

    }

    override fun onBackStackChanged() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            toolbar.setNavigationOnClickListener(null)
            mToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open, R.string.close)
            drawer_layout.addDrawerListener(mToggle!!)
            mToggle!!.syncState()
        } else {
            mToggle!!.isDrawerIndicatorEnabled = false
            toolbar.setNavigationOnClickListener(this)
        }
    }

    override fun onClick(p0: View?) {
        closeFragment(R.id.main_fragment_container)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        mCurrentFragmentEnum = when (item.itemId) {
            R.id.weathers -> FragmentEnum.WEATHER_FRAGMENT
            R.id.settings -> FragmentEnum.SETTINGS_FRAGMENT
            R.id.choose_city -> FragmentEnum.CHOICE_CITY_FRAGMENT
            else -> FragmentEnum.WEATHER_FRAGMENT
        }

        drawer_layout.closeDrawers()
        progress_bar_layout.visibility = View.VISIBLE

        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null

        mToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open, R.string.close)
        drawer_layout.addDrawerListener(mToggle!!)
        mToggle!!.syncState()

        supportFragmentManager.addOnBackStackChangedListener(this)

        drawer_layout.addDrawerListener(this)
        nav_view.setNavigationItemSelectedListener(this)

        val fragment = WeatherFragment.newInstance(Bundle())
        replaceFragment(R.id.main_fragment_container, fragment, fragment.toString(), false)

    }
}
