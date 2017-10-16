package com.ansgar.kotlinweatherapp.ui.fragments

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ansgar.kotlinweatherapp.R
import com.ansgar.kotlinweatherapp.ui.presenters.WeatherFragmentPresenter
import com.ansgar.kotlinweatherapp.ui.views.WeatherFragmentView
import com.ansgar.kotlinweatherapp.utils.loadUri
import kotlinx.android.synthetic.main.fragment_weather.view.*

/**
 * Created by kirill on 2.10.17.
 */
class WeatherFragment : Fragment(), WeatherFragmentView {

    private var presenter: WeatherFragmentPresenter = WeatherFragmentPresenter(this)

    override fun setCity(city: String) {
        view?.city?.text = city
    }

    override fun setIcon(icon: Uri) {
        view?.weather_icon?.loadUri(icon)
    }

    override fun setTemp(temp: Double) {
        view?.temp?.text = getString(R.string.temperature, temp)
    }

    override fun setMin(min: Double) {
        view?.min_temp?.text = getString(R.string.min, min)
    }

    override fun setMax(max: Double) {
        view?.max_temp?.text = getString(R.string.max, max)
    }

    override fun setPressure(pressure: Double) {
        view?.pressure?.text = getString(R.string.pressure, pressure)
    }

    override fun setHumidity(humidity: Double) {
        view?.humidity?.text = getString(R.string.humidity, humidity)
    }

    override fun setWindSpeed(speed: Double) {
        view?.wind?.text = getString(R.string.wind, speed)
    }

    companion object {
        fun newInstance(bundle: Bundle): WeatherFragment {
            val fragment = WeatherFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_weather, container, false)

    override fun onStart() {
        super.onStart()
        presenter.getCurrentWeather(625144, getString(R.string.api_key))
    }

    override fun toString(): String = WeatherFragment::class.java.simpleName

}