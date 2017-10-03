package com.ansgar.kotlinweatherapp.ui.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.ansgar.kotlinweatherapp.ui.fragments.WeatherFragment

/**
 * Created by kirill on 3.10.17.
 */
class WeatherAdapter : FragmentStatePagerAdapter {

    var childFragment: FragmentManager

    constructor(childFragment: FragmentManager) : super(childFragment) {
        this.childFragment = childFragment
    }
//    var weathers: List<Weathers>

//    constructor(fm: FragmentManager?, childFragment: FragmentManager, weathers: List<Weathers>) : super(fm) {
//        this.childFragment = childFragment
//        this.weathers = weathers
//    }

    override fun getItem(position: Int): Fragment {
        val args = Bundle()
        args.putInt("position", position)
        return WeatherFragment.newInstance(args)
    }

    override fun getCount(): Int = 1

}