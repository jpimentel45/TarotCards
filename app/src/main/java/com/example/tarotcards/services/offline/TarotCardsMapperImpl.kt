package com.example.tarotcards.services.offline

import com.example.tarotcards.model.TarotCards
import com.example.tarotcards.network.dto.TarotApiResponse

object TarotCardsMapperImpl : TarotCardsMapper {
    override fun toJuanitoModel(tarotApiResponse: TarotApiResponse): List<TarotCards>? = tarotApiResponse.cards?.map {tarotCardResponse ->
            TarotCards(
               tarotCardResponse?.valueInt ?: 0,
                tarotCardResponse?.meaningUp ?: "",
                tarotCardResponse?.meaningRev ?: "",
                tarotCardResponse?.name ?: "",
                tarotCardResponse?.nameShort ?: "",
                tarotCardResponse?.type ?: "",
                tarotCardResponse?.value ?: "",
                tarotCardResponse?.desc ?: "",
            )
    }
}