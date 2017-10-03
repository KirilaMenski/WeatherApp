package com.ansgar.kotlinweatherapp.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ansgar.kotlinweatherapp.R
import com.ansgar.kotlinweatherapp.ui.adapter.WeatherAdapter
import kotlinx.android.synthetic.main.fragment_weather.*
import kotlinx.android.synthetic.main.pager_weather.*

/**
 * Created by kirill on 3.10.17.
 */
class WeatherPager : Fragment() {

    companion object {
        fun newInstance(bundle: Bundle): WeatherPager {
            val pager = WeatherPager()
            pager.arguments = bundle
            return pager
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.pager_weather, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
//        weather_view_pager.adapter = WeatherAdapter(childFragmentManager)
        weather_view_pager.adapter = weatherAdapter
    }

    private val weatherAdapter: FragmentStatePagerAdapter
        get() = object : FragmentStatePagerAdapter(childFragmentManager) {
            override fun getItem(position: Int): Fragment {
                val args = Bundle()
                args.putInt("position", position)
                return WeatherFragment.newInstance(args)
            }

            override fun getCount(): Int = 10

        }

}