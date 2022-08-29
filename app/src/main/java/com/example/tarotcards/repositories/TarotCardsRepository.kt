package com.example.tarotcards.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.tarotcards.model.TarotCardModel
import com.example.tarotcards.tarotroom.TarotCardsDao
import com.example.tarotcards.tarotroom.TarotCardsDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TarotCardsRepository(application: Application) {
    private var tarotCardsDao: TarotCardsDao
    private var allTarotCardModel: LiveData<List<TarotCardModel>>
    private val database = TarotCardsDatabase.getInstance(application)

    init {
        tarotCardsDao = database.tarotCardsDao()
        allTarotCardModel = tarotCardsDao.getAllTarotCards()
    }

    suspend fun insertAll(tarot: List<TarotCardModel>) = withContext(Dispatchers.IO) {
        tarotCardsDao.insertAll(tarot)
    }

    suspend fun insert(tarot: TarotCardModel) = withContext(Dispatchers.IO) {
        tarotCardsDao.insert(tarot)
    }

    suspend fun update(tarot: TarotCardModel) = withContext(Dispatchers.IO) {
        tarotCardsDao.update(tarot)
    }

    suspend fun delete(tarot: TarotCardModel) = withContext(Dispatchers.IO) {
        tarotCardsDao.delete(tarot)
    }

    suspend fun deleteAll() = withContext(Dispatchers.IO) {
        tarotCardsDao.deleteAllTarotCards()
    }

    fun getAllTarotCards(): LiveData<List<TarotCardModel>> = allTarotCardModel
}