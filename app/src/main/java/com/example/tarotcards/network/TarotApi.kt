package com.example.tarotcards.network

object TarotApi {
    fun tarotRetrofitService() : TarotService = RetrofitInstance().retrofit.create(TarotService::class.java)

}