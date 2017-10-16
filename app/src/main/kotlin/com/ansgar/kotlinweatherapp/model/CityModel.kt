package com.ansgar.kotlinweatherapp.model

/**
 * Created by kirill on 16.10.17.
 */
class CityModel {
    var id: Int = 0
    var name: String? = null
    var latitude: Double = 0.0
    var longitude: Double = 0.0

    override fun toString(): String {
        return "CityModel(id=$id, name=$name, latitude=$latitude, longitude=$longitude)"
    }
}