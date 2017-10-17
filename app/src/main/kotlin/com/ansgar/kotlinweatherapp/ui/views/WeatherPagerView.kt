package com.ansgar.kotlinweatherapp.ui.views

import com.ansgar.kotlinweatherapp.model.CityModel
import com.ansgar.kotlinweatherapp.ui.base.BaseContext

/**
 * Created by kirill on 17.10.17.
 */
interface WeatherPagerView : BaseContext {

    fun updateAdapter(cityModels: List<CityModel>)

}