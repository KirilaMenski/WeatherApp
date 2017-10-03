package com.ansgar.kotlinweatherapp.api

import com.ansgar.kotlinweatherapp.model.CurrentWeatherResponse
import com.ansgar.kotlinweatherapp.model.DailyWeatherResponse
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable

/**
 * Created by kirill on 3.10.17.
 */
interface ApiInterface {


    @POST("weather")
    fun getCurrentWeather(@Query("id") cityId: Int, @Query("appid") appId: String): Observable<CurrentWeatherResponse>

    @POST("forecast/daily")
    fun getDailyWeather(@Query("id") cityId: Int, @Query("appid") appId: String): Observable<DailyWeatherResponse>

}