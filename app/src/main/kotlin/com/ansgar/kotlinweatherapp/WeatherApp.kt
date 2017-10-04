package com.ansgar.kotlinweatherapp

import android.support.multidex.MultiDexApplication
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by kirill on 4.10.17.
 */
class WeatherApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name("weather_app_db")
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

}