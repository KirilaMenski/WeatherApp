package com.ansgar.kotlinweatherapp.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ansgar.kotlinweatherapp.R
import com.ansgar.kotlinweatherapp.model.CityModel
import com.ansgar.kotlinweatherapp.ui.adapter.CityListAdapter
import com.ansgar.kotlinweatherapp.ui.presenters.ChoiceCityFragmentPresenter
import com.ansgar.kotlinweatherapp.ui.views.ChoiceCityFragmentView
import kotlinx.android.synthetic.main.fragment_choice_city.*
import java.util.*

/**
 * Created by kirill on 2.10.17.
 */
class ChoiceCityFragment : Fragment(), ChoiceCityFragmentView {

    private var mPresenter: ChoiceCityFragmentPresenter = ChoiceCityFragmentPresenter(this)
    private var mCityModelList: MutableList<CityModel> = ArrayList()
    private var mAdapter: CityListAdapter? = null

    override fun updateList(cityModel: CityModel) {
        mCityModelList.add(cityModel)

        mAdapter = CityListAdapter(mCityModelList, context)

        city_list.layoutManager = LinearLayoutManager(context)
        city_list.adapter = mAdapter
    }

    override fun sortList() {
        Collections.sort(mCityModelList, CityModel())
    }

    companion object {
        fun newInstance(bundle: Bundle): ChoiceCityFragment {
            val fragment = ChoiceCityFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_choice_city, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
        mPresenter.getCitiesList(context.assets.open("locations/city.txt"))
    }

    override fun toString(): String = ChoiceCityFragment::class.java.simpleName

}