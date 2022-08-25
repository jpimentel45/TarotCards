package com.example.tarotcards.tarotroom

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tarotcards.model.TarotCards

@Dao
interface TarotCardsDao {
    @Insert
    fun insertAll(tarotCards: List<TarotCards>)

    @Insert
    fun insert(tarot: TarotCards)

    @Update
    fun update(tarot: TarotCards)

    @Delete
    fun delete(tarot: TarotCards)

    @Query("delete from tarot_cards_table")
    fun deleteAllTarotCards()

    @Query("select * from tarot_cards_table order by id desc")
    fun getAllTarotCards(): LiveData<List<TarotCards>>
}