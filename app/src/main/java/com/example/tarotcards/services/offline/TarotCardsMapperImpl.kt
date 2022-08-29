package com.example.tarotcards.services.offline

import com.example.tarotcards.model.TarotCardModel
import com.example.tarotcards.network.dto.TarotApiResponse

object TarotCardsMapperImpl : TarotCardsMapper {
    override fun toJuanitoModel(tarotApiResponse: TarotApiResponse): List<TarotCardModel>? = tarotApiResponse.cards?.map { tarotCardResponse ->
            TarotCardModel(
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