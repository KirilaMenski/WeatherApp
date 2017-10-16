package com.ansgar.kotlinweatherapp.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.io.Serializable
import java.util.*

/**
 * Created by kirill on 3.10.17.
 */

// Error Response
class ServerResponse(@SerializedName("error") var error: String) : Serializable


//Weather forecast for a week
@RealmClass
open class DailyWeatherResponse : RealmObject() {
    @PrimaryKey
    var id: Int = 0
    @SerializedName("city")
    var city: City? = null
    @SerializedName("cod")
    var cod: Int = 0
    @SerializedName("message")
    var message: Double = 0.0
    @SerializedName("cnt")
    var count: Int = 0
    @SerializedName("list")
    var list: RealmList<List>? = null
}

@RealmClass
open class City : RealmObject() {
    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("name")
    var name: String? = null
    @SerializedName("coord")
    var coordinates: Coordination? = null
    @SerializedName("country")
    var country: String? = null
    @SerializedName("population")
    var population: Int = 0
}

@RealmClass
open class List : RealmObject() {
    @SerializedName("dt")
    var dt: Long = 0
    @SerializedName("temp")
    var temperature: Temperature? = null
    @SerializedName("pressure")
    var pressure: Double = 0.0
    @SerializedName("humidity")
    var humidity: Double = 0.0
    @SerializedName("weather")
    var weatherDescription: RealmList<Weather>? = null
    @SerializedName("speed")
    var speed: Double = 0.0
    @SerializedName("deg")
    var deg: Double = 0.0
    @SerializedName("clouds")
    var clouds: Int = 0
}

@RealmClass
open class Temperature : RealmObject() {
    @PrimaryKey
    var id: Int = 0
    @SerializedName("day")
    var day: Double = 0.0
    @SerializedName("night")
    var night: Double = 0.0
    @SerializedName("eve")
    var evening: Double = 0.0
    @SerializedName("morning")
    var morning: Double = 0.0
}

//Forecast for today

@RealmClass
open class CurrentWeatherResponse : RealmObject() {
    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("coord")
    var coord: Coordination? = null
    @SerializedName("weather")
    var weatherDescription: RealmList<Weather>? = null
    @SerializedName("base")
    var base: String? = null
    @SerializedName("main")
    var main: Main? = null
    @SerializedName("wind")
    var wind: Wind? = null
    @SerializedName("dt")
    var dt: Long = 0
    @SerializedName("sys")
    var sys: Systematic? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("cod")
    var cod: Int = 0
}

@RealmClass
open class Main : RealmObject() {
    @PrimaryKey
    var id: Int = 0
    @SerializedName("temp")
    var temp: Double = 0.0
    @SerializedName("temp_max")
    var max: Double = 0.0
    @SerializedName("temp_min")
    var min: Double = 0.0
    @SerializedName("humidity")
    var humidity: Double = 0.0
    @SerializedName("pressure")
    var pressure: Double = 0.0
}

// Common
@RealmClass
open class Coordination : RealmObject() {
    @PrimaryKey
    var id: Int = 0
    @SerializedName("lon")
    var longitude: Double = 0.0
    @SerializedName("lat")
    var latitude: Double = 0.0
}

@RealmClass
open class Weather : RealmObject() {
    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("main")
    var main: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("icon")
    var icon: String? = null
}

@RealmClass
open class Wind : RealmObject() {
    @SerializedName("speed")
    var speed: Double = 0.0
    @SerializedName("deg")
    var deg: Double = 0.0
}

@RealmClass
open class Systematic : RealmObject() {
    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("type")
    var type: Int = 0
    @SerializedName("message")
    var message: Double = 0.0
    @SerializedName("country")
    var country: String? = null
    @SerializedName("sunrise")
    var sunrise: Long = 0
    @SerializedName("sunset")
    var sunset: Long = 0
}
