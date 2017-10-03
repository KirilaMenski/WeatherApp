package com.ansgar.kotlinweatherapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by kirill on 3.10.17.
 */

// Error Response
class ServerResponse(@SerializedName("error") var error: String) : Serializable


//Weather forecast for a week
class DailyWeatherResponse(@SerializedName("city") var city: City,
                           @SerializedName("cod") var cod: Int,
                           @SerializedName("message") var message: Double,
                           @SerializedName("cnt") var count: Int,
                           @SerializedName("list") var list: ArrayList<Weather>)

class City(@SerializedName("id") var id: Int,
           @SerializedName("name") var name: String,
           @SerializedName("coord") var coordinates: CityCoordinateResponse,
           @SerializedName("country") var country: String,
           @SerializedName("population") var population: Int)

class Weather(@SerializedName("dt") var dt: Long,
              @SerializedName("temp") var temperature: TemperatureResponse,
              @SerializedName("pressure") var pressure: Double,
              @SerializedName("humidity") var humidity: Double,
              @SerializedName("weather") var weatherDescription: ArrayList<WeatherDescriptionResponse>,
              @SerializedName("speed") var speed: Double,
              @SerializedName("deg") var deg: Double,
              @SerializedName("clouds") var clouds: Int)

class TemperatureResponse(@SerializedName("day") var day: Double,
                          @SerializedName("night") var night: Double,
                          @SerializedName("eve") var evening: Double,
                          @SerializedName("morning") var morning: Double)

//Forecast for today
class CurrentWeatherResponse(@SerializedName("coord") var coord: CityCoordinateResponse,
                             @SerializedName("weather") var weatherDescription: ArrayList<WeatherDescriptionResponse>,
                             @SerializedName("base") var base: String,
                             @SerializedName("main") var main: CurrentTemperatureResponse,
                             @SerializedName("wind") var windResponse: WindResponse,
                             @SerializedName("dt") var dt: Long,
                             @SerializedName("sys") var sys: SysResponse,
                             @SerializedName("id") var id: Int,
                             @SerializedName("name") var name: String,
                             @SerializedName("cod") var cod: Int)

class CurrentTemperatureResponse(@SerializedName("temp") var temp: Double,
                                 @SerializedName("temp_max") var max: Double,
                                 @SerializedName("temp_min") var min: Double,
                                 @SerializedName("humidity") var humidity: Double,
                                 @SerializedName("pressure") var pressure: Double)

// Common
class CityCoordinateResponse(@SerializedName("lon") var longitude: Double,
                             @SerializedName("lat") var latitude: Double)

class WeatherDescriptionResponse(@SerializedName("id") var id: Int,
                                 @SerializedName("main") var main: String,
                                 @SerializedName("description") var description: String,
                                 @SerializedName("icon") var icon: String)

class WindResponse(@SerializedName("speed") var speed: Double,
                   @SerializedName("deg") var deg: Double)

class SysResponse(@SerializedName("type") var type: Int,
                  @SerializedName("id") var id: Int,
                  @SerializedName("message") var message: Double,
                  @SerializedName("country") var country: String,
                  @SerializedName("sunrise") var sunrise: Long,
                  @SerializedName("sunset") var sunset: Long)
