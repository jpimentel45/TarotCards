package com.example.tarotcards.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitInstance {

    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Companion.BASE_URL)
        .build()

    companion object {
        private const val BASE_URL = "https://rws-cards-api.herokuapp.com/api/v1/"
    }
}