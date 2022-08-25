package com.example.tarotcards.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tarot_cards_table")
data class TarotCards(
    val id: Int,
    val meaningUp: String,
    val meaningRev: String,
    val name: String,
    val nameShort: String,
    val type: String,
    val value: String,
    val desc: String,

    ) {
    @PrimaryKey(autoGenerate = true)
    var databaseID: Int = 0
}
