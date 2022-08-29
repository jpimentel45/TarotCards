package com.example.tarotcards.tarotroom

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tarotcards.model.TarotCardModel

@Dao
interface TarotCardsDao {
    @Insert
    fun insertAll(tarotCards: List<TarotCardModel>)

    @Insert
    fun insert(tarot: TarotCardModel)

    @Update
    fun update(tarot: TarotCardModel)

    @Delete
    fun delete(tarot: TarotCardModel)

    @Query("delete from tarot_cards_table")
    fun deleteAllTarotCards()

    @Query("select * from tarot_cards_table order by id desc")
    fun getAllTarotCards(): LiveData<List<TarotCardModel>>
}