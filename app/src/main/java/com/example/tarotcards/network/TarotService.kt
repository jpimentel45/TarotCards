package com.example.tarotcards.network

import com.example.tarotcards.network.dto.TarotApiResponse
import retrofit2.http.GET

interface TarotService {
    @GET("cards")
    suspend fun getCards() : TarotApiResponse
}