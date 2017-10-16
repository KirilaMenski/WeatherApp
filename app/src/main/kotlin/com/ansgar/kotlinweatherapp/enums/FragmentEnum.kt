package com.ansgar.kotlinweatherapp.enums

/**
 * Created by kirill on 2.10.17.
 */
enum class FragmentEnum {
    WEATHER_PAGER {
        override fun signal(): FragmentEnum = WEATHER_PAGER
    },
    CHOICE_CITY_FRAGMENT {
        override fun signal(): FragmentEnum = CHOICE_CITY_FRAGMENT
    },
    SETTINGS_FRAGMENT {
        override fun signal(): FragmentEnum = SETTINGS_FRAGMENT
    };

    abstract fun signal(): FragmentEnum
}