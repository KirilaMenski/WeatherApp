package com.ansgar.kotlinweatherapp.ui.views

import com.ansgar.kotlinweatherapp.model.CityModel
import com.ansgar.kotlinweatherapp.ui.base.BaseContext

/**
 * Created by kirill on 16.10.17.
 */
interface ChoiceCityFragmentView : BaseContext {

    fun updateList(list: List<CityModel>)

}