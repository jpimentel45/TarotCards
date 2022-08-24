package com.example.tarotcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.tarotcards.tarot.TarotViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : TarotViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[TarotViewModel::class.java]
        viewModel.getTarotCards()
        val view = findViewById<TextView>(R.id.tv_hello)
        viewModel.list.observe(this){
            view.text = it.toString()
        }
    }
}