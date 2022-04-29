package com.example.mykotproj

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BoredApiService {

    @GET("api/activity/")
    fun getBoredActivity(

    ): Observable<Model.Result>


    companion object {
        fun create(): BoredApiService{
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.boredapi.com/")
                .build()

            return retrofit.create(BoredApiService::class.java)
        }
    }

}