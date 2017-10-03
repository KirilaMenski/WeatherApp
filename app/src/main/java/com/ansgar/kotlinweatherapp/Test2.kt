package com.ansgar.kotlinweatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

import com.ansgar.kotlinweatherapp.api.ApiRequest
import com.ansgar.kotlinweatherapp.model.CurrentWeatherResponse

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.adapter.rxjava.HttpException
import rx.Observable
import rx.Observer

/**
 * Created by kirill on 3.10.17.
 */

class Test2 : AppCompatActivity() {

    val str = "!#Eqd"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun getServerResponse(throwable: Throwable): String {
        val observable = ApiRequest.getInstance().api.getCurrentWeather(1, "")
        val observer = object : Observer<CurrentWeatherResponse> {
            override fun onCompleted() {

            }

            override fun onError(e: Throwable) {

            }

            override fun onNext(currentWeatherResponse: CurrentWeatherResponse) {

            }
        }
        return ""
    }
}
