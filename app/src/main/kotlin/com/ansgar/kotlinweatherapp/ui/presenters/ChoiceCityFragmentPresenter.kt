package com.ansgar.kotlinweatherapp.ui.presenters

import android.util.Log
import com.ansgar.kotlinweatherapp.model.City
import com.ansgar.kotlinweatherapp.model.CityModel
import com.ansgar.kotlinweatherapp.ui.views.ChoiceCityFragmentView
import rx.Observable
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Created by kirill on 16.10.17.
 */
class ChoiceCityFragmentPresenter(var view: ChoiceCityFragmentView) {

    fun getCitiesList(assetsInputStream: InputStream) {
        val observable: Observable<CityModel> = getList(assetsInputStream)
        val observer: Observer<CityModel> = object : Observer<CityModel> {
            override fun onCompleted() {
                Log.i("!!!", "Complete")
            }

            override fun onError(e: Throwable?) {
                Log.e("!!!", "Error", e)
            }

            override fun onNext(t: CityModel?) {
                Log.i("!!!", "City: " + t.toString())
            }
        }

        observable.subscribeOn(Schedulers.newThread())
                .onBackpressureBuffer()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)

    }

    private fun getList(assetsInputStream: InputStream): Observable<CityModel>
            = Observable.create { subscriber ->
        run {
            val reader = BufferedReader(InputStreamReader(assetsInputStream))
            var line: String = reader.readLine()

            while (!line.isNullOrEmpty()) {
                if (reader.readLine() != null) {
                    line = reader.readLine()
                    val lineList = line.split("|")

                    val city = CityModel()
                    city.id = lineList[0].toInt()
                    city.name = lineList[1]
                    city.latitude = lineList[2].toDouble()
                    city.longitude = lineList[3].toDouble()

                    subscriber.onNext(city)
                } else {
                    reader.close()
                    subscriber.onCompleted()
                }
            }

            reader.close()
            subscriber.onCompleted()

        }
    }

}