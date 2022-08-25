package com.example.tarotcards

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tarotcards.repositories.TarotCardsRepository
import com.example.tarotcards.tarot.TarotViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: TarotViewModel
    private lateinit var repo: TarotCardsRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repo = TarotCardsRepository(application)
        viewModel = ViewModelProvider(this)[TarotViewModel::class.java]
        viewModel.getTarotCards()
        val view = findViewById<TextView>(R.id.tv_hello)
        viewModel.list.observe(this){
            view.text = it.toString()
            lifecycleScope.launch(Dispatchers.Unconfined) {
                repo.insertAll(it ?: emptyList())

            }
        }
    }
}