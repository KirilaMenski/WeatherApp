package com.ansgar.kotlinweatherapp.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ansgar.kotlinweatherapp.R

/**
 * Created by kirill on 2.10.17.
 */
class ChoiceCityFragment : Fragment() {

    companion object {
        fun newInstance(bundle: Bundle): ChoiceCityFragment {
            val fragment = ChoiceCityFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_choice_city, container, false)
        return view
    }

    override fun toString(): String = ChoiceCityFragment::class.java.simpleName

}