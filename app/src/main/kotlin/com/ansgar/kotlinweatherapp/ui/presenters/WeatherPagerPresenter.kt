package com.ansgar.kotlinweatherapp.ui.presenters

import com.ansgar.kotlinweatherapp.model.CityModel
import com.ansgar.kotlinweatherapp.ui.views.WeatherPagerView
import com.vicpin.krealmextensions.queryAll

/**
 * Created by kirill on 17.10.17.
 */
class WeatherPagerPresenter(var view: WeatherPagerView) {

    fun getCities() {
        val cityModels = CityModel().queryAll()
        view.updateAdapter(cityModels)
    }
}