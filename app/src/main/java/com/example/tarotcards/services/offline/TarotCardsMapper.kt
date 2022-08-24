package com.example.tarotcards.services.offline

import com.example.tarotcards.model.TarotCards
import com.example.tarotcards.network.dto.TarotApiResponse

interface TarotCardsMapper {
    fun toJuanitoModel(tarotApiResponse: TarotApiResponse) : List<TarotCards>?
}