package com.ansgar.kotlinweatherapp;

import com.ansgar.kotlinweatherapp.model.CityModel;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by kirill on 16.10.17.
 */

public class c {


    public void method(){
        Observable<CityModel> observable = Observable.create(new Observable.OnSubscribe<CityModel>() {
            @Override
            public void call(Subscriber<? super CityModel> subscriber) {
                subscriber.onCompleted();
            }
        });
    }
}
