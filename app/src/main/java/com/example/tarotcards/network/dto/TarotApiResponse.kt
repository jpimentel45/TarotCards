package com.example.tarotcards.network.dto

import com.google.gson.annotations.SerializedName

data class TarotApiResponse(

    @field:SerializedName("nhits")
    val nhits: Int? = null,

    @field:SerializedName("cards")
    val cards: List<TarotCard?>? = null
) {
    data class TarotCard(

        @field:SerializedName("value_int")
        val valueInt: Int? = null,

        @field:SerializedName("meaning_up")
        val meaningUp: String? = null,

        @field:SerializedName("meaning_rev")
        val meaningRev: String? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("name_short")
        val nameShort: String? = null,

        @field:SerializedName("type")
        val type: String? = null,

        @field:SerializedName("value")
        val value: String? = null,

        @field:SerializedName("desc")
        val desc: String? = null
    )
}


