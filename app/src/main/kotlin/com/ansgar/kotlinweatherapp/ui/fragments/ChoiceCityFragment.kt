package com.ansgar.kotlinweatherapp.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ansgar.kotlinweatherapp.R
import com.ansgar.kotlinweatherapp.model.CityModel
import com.ansgar.kotlinweatherapp.ui.presenters.ChoiceCityFragmentPresenter
import com.ansgar.kotlinweatherapp.ui.views.ChoiceCityFragmentView

/**
 * Created by kirill on 2.10.17.
 */
class ChoiceCityFragment : Fragment(), ChoiceCityFragmentView {

    private var presenter: ChoiceCityFragmentPresenter = ChoiceCityFragmentPresenter(this)

    override fun updateList(list: List<CityModel>) {

    }

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

    override fun onStart() {
        super.onStart()
        presenter.getCitiesList(context.assets.open("locations/city.txt"))
    }

    override fun toString(): String = ChoiceCityFragment::class.java.simpleName

}