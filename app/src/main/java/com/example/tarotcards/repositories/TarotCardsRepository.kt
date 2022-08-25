package com.example.tarotcards.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.tarotcards.model.TarotCards
import com.example.tarotcards.tarotroom.TarotCardsDao
import com.example.tarotcards.tarotroom.TarotCardsDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TarotCardsRepository(application: Application) {
    private var tarotCardsDao: TarotCardsDao
    private var allTarotCards: LiveData<List<TarotCards>>
    private val database = TarotCardsDatabase.getInstance(application)

    init {
        tarotCardsDao = database.tarotCardsDao()
        allTarotCards = tarotCardsDao.getAllTarotCards()
    }

    suspend fun insertAll(tarot: List<TarotCards>) = withContext(Dispatchers.IO) {
        tarotCardsDao.insertAll(tarot)
    }

    suspend fun insert(tarot: TarotCards) = withContext(Dispatchers.IO) {
        tarotCardsDao.insert(tarot)
    }

    suspend fun update(tarot: TarotCards) = withContext(Dispatchers.IO) {
        tarotCardsDao.update(tarot)
    }

    suspend fun delete(tarot: TarotCards) = withContext(Dispatchers.IO) {
        tarotCardsDao.delete(tarot)
    }

    suspend fun deleteAll() = withContext(Dispatchers.IO) {
        tarotCardsDao.deleteAllTarotCards()
    }

    fun getAllTarotCards(): LiveData<List<TarotCards>> = allTarotCards
}