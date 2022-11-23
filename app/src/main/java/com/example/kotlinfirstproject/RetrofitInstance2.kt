package com.example.kotlinfirstproject

import android.app.Application
import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance2{

    var sessionManager = SessionManager(MyApplication.appContext!!)

    var BAseUrl = sessionManager.getBaseURL(MyApplication.appContext!!)

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BAseUrl)
            .addConverterFactory(GsonConverterFactory.create())

            .build()
    }
}