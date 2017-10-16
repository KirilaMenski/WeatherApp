package com.ansgar.kotlinweatherapp.ui.presenters

import android.net.Uri
import android.util.Log.*
import com.ansgar.kotlinweatherapp.api.ApiRequest
import com.ansgar.kotlinweatherapp.model.CurrentWeatherResponse
import com.ansgar.kotlinweatherapp.ui.views.WeatherFragmentView
import com.vicpin.krealmextensions.queryAll
import com.vicpin.krealmextensions.save
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

/**
 * Created by kirill on 3.10.17.
 */
class WeatherFragmentPresenter(var view: WeatherFragmentView) {

    fun getCurrentWeather(cityId: Int, appId: String) {

        var weather: List<CurrentWeatherResponse>

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
                view.setTemp(temp - 273)
                view.setMax(max - 273)
                view.setMin(min - 273)
                view.setPressure(pressure)
                view.setIcon(Uri.parse("http://openweathermap.org/img/w/$icon.png"))

                weather = CurrentWeatherResponse().queryAll()

                i("Weather", "Complete: ")
                i("Weather", "Size: " + weather.size)
                i("Weather", "Dt: " + weather[0].dt)

            }

            override fun onError(e: Throwable?) {
                e("WeatherFragment", "", e)
            }

            override fun onNext(weatherResponse: CurrentWeatherResponse?) {
                city = weatherResponse?.name!!
                humidity = weatherResponse.main!!.humidity
                speed = weatherResponse.wind!!.speed
                temp = weatherResponse.main!!.temp
                max = weatherResponse.main!!.max
                min = weatherResponse.main!!.min
                pressure = weatherResponse.main!!.pressure
                icon = weatherResponse.weatherDescription!![0].icon!!

                weatherResponse.main!!.id = weatherResponse.id
                weatherResponse.coord!!.id = weatherResponse.id
                weatherResponse.save()

            }

        }

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

    }

}