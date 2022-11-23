package com.example.kotlinfirstproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val BaseUrl = "https://workunderconstruction.com/demo/hiyamate-dev/code/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())

            .build()
    }
}