package com.example.tarotcards.tarot

import androidx.recyclerview.widget.DiffUtil
import com.example.tarotcards.model.TarotCardModel

object TarotCardItemCallback : DiffUtil.ItemCallback<TarotCardModel>(){
    override fun areContentsTheSame(oldItem: TarotCardModel, newItem: TarotCardModel): Boolean {
        return oldItem == newItem
    }
    override fun areItemsTheSame(oldItem: TarotCardModel, newItem: TarotCardModel): Boolean {
        return oldItem.databaseID == newItem.databaseID &&
            oldItem.desc == newItem.desc
    }
}