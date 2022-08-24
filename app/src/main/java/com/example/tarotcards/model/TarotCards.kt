package com.example.tarotcards.model

import com.google.gson.annotations.SerializedName

data class TarotCards(
    val id : Int,
    val meaningUp : String,
    val meaningRev :String,
    val name: String,
    val nameShort: String,
    val type: String,
    val value: String,
    val desc: String
)
