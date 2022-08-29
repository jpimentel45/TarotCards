package com.example.tarotcards.util

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tarotcards.repositories.TarotCardsRepository

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var repo: TarotCardsRepository

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        repo  = application?.let { TarotCardsRepository(it) }!!

    }

    fun getRepo() : TarotCardsRepository = repo
}