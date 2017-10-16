package com.ansgar.kotlinweatherapp.api

import com.ansgar.kotlinweatherapp.model.ServerResponse
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.HttpException
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by kirill on 3.10.17.
 */
class ApiRequest private constructor() {

    val MAIN_URL: String = "http://api.openweathermap.org/data/2.5/"

    var api: ApiInterface


    companion object {
        fun getInstance(): ApiRequest = ApiRequest()
    }

    init {
        val retrofit: Retrofit = getRetrofit()
        api = retrofit.create(ApiInterface::class.java)
    }

    private fun getRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(interceptor)
        client.readTimeout(5 * 60, TimeUnit.SECONDS)
        client.addInterceptor { chain ->
            val original: Request = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
            requestBuilder.addHeader("Content-Type", "application/json")
            val request: Request = requestBuilder.method(original.method(), original.body())
                    .build()
            chain.proceed(request)
        }

        val gson = GsonBuilder().addSerializationExclusionStrategy(object : ExclusionStrategy {
            override fun shouldSkipClass(clazz: Class<*>?): Boolean = false

            override fun shouldSkipField(f: FieldAttributes?): Boolean =
                    f!!.getAnnotation(SerializedName::class.java) == null

        }).create()

        return Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(MAIN_URL)
                .client(client.build())
                .build()

    }

    private fun getServerResponse(throwable: Throwable): String {
        if (throwable is HttpException) {
            val retrofit = getRetrofit().responseBodyConverter<ServerResponse>(ServerResponse::class.java, arrayOf())
            try {
                val response = retrofit.convert(throwable.response().errorBody())
                return response.error
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        return ""
    }

}