package com.ansgar.kotlinweatherapp.ui.presenters

import android.net.Uri
import android.util.Log
import com.ansgar.kotlinweatherapp.api.ApiRequest
import com.ansgar.kotlinweatherapp.model.CurrentWeatherResponse
import com.ansgar.kotlinweatherapp.ui.views.WeatherFragmentView
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by kirill on 3.10.17.
 */
class WeatherFragmentPresenter(var view: WeatherFragmentView) {

    fun getCurrentWeather(cityId: Int, appId: String) {

        var temp = 0.0
        var min = 0.0
        var max = 0.0
        var city = ""
        var speed = 0.0
        var pressure = 0.0
        var humidity = 0.0
        var icon = ""

        val observable = ApiRequest.getInstance().api.getCurrentWeather(cityId, appId)
        val observer = object : Observer<CurrentWeatherResponse> {
            override fun onCompleted() {
                view.setCity(city)
                view.setHumidity(humidity)
                view.setWindSpeed(speed)
                view.setTemp(temp)
                view.setMax(max)
                view.setMin(min)
                view.setPressure(pressure)
                view.setIcon(Uri.parse("http://openweathermap.org/img/w/$icon.png"))
            }

            override fun onError(e: Throwable?) {
                Log.e("WeatherFragment", "", e)
            }

            override fun onNext(t: CurrentWeatherResponse?) {
                city = t?.name!!
                humidity = t.main.humidity
                speed = t.windResponse.speed
                temp = t.main.temp
                max = t.main.max
                min = t.main.min
                pressure = t.main.pressure
                icon = t.weatherDescription[0].icon
            }

        }

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

    }

}