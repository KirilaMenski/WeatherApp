package com.ansgar.kotlinweatherapp.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by kirill on 16.10.17.
 */

@RealmClass
open class CityModel : Comparator<CityModel>, RealmObject(){

    @PrimaryKey
    var id: Int = 0
    var name: String? = null
    var latitude: Double = 0.0
    var longitude: Double = 0.0

    override fun toString(): String =
            "CityModel(id=$id, name=$name, latitude=$latitude, longitude=$longitude)"

    override fun compare(o1: CityModel?, o2: CityModel?): Int {
        val name: String = o1!!.name!!.toLowerCase().trim()
        val name2: String = o2!!.name!!.toLowerCase().trim()
        return name.compareTo(name2)
    }
}