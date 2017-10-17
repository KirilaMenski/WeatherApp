package com.ansgar.kotlinweatherapp.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ansgar.kotlinweatherapp.R
import com.ansgar.kotlinweatherapp.model.CityModel
import com.ansgar.kotlinweatherapp.ui.adapter.WeatherAdapter
import com.ansgar.kotlinweatherapp.ui.presenters.WeatherPagerPresenter
import com.ansgar.kotlinweatherapp.ui.views.WeatherPagerView
import kotlinx.android.synthetic.main.fragment_weather.*
import kotlinx.android.synthetic.main.pager_weather.*

/**
 * Created by kirill on 3.10.17.
 */
class WeatherPager : Fragment(), WeatherPagerView {

    override fun updateAdapter(cityModels: List<CityModel>) {
        weather_view_pager.adapter = object : FragmentStatePagerAdapter(childFragmentManager) {

            override fun getItem(position: Int): Fragment {
                val args = Bundle()
                args.putInt(WeatherFragment.EXTRA_ID, cityModels[position].id)

                return WeatherFragment.newInstance(args)
            }

            override fun getCount(): Int = cityModels.size

        }
    }

    var mPresenter = WeatherPagerPresenter(this)

    companion object {
        fun newInstance(bundle: Bundle): WeatherPager {
            val pager = WeatherPager()
            pager.arguments = bundle
            return pager
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.pager_weather, container, false)

    override fun onStart() {
        super.onStart()
//        weather_view_pager.adapter = WeatherAdapter(childFragmentManager)
        mPresenter.getCities()
    }

}