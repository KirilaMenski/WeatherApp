package com.ansgar.kotlinweatherapp.ui.views

import android.net.Uri
import com.ansgar.kotlinweatherapp.ui.base.BaseContext

/**
 * Created by kirill on 2.10.17.
 */
interface WeatherFragmentView : BaseContext {

    fun setCity(city: String)

    fun setIcon(icon: Uri)

    fun setTemp(temp: Double)

    fun setMin(min: Double)

    fun setMax(max: Double)

    fun setPressure(pressure: Double)

    fun setHumidity(humidity: Double)

    fun setWindSpeed(speed: Double)

}