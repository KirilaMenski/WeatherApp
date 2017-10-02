package com.ansgar.kotlinweatherapp.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ansgar.kotlinweatherapp.R
import com.ansgar.kotlinweatherapp.ui.views.WeatherFragmentView

/**
 * Created by kirill on 2.10.17.
 */
class WeatherFragment : Fragment(), WeatherFragmentView {

    companion object {
        fun newInstance(bundle: Bundle): WeatherFragment {
            val fragment = WeatherFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_weather, container, false)
        return view
    }

    override fun toString(): String = WeatherFragment::class.java.simpleName

}