package com.example.tarotcards.tarot

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tarotcards.databinding.TarotCardBinding
import com.example.tarotcards.model.TarotCardModel

class TarotCardAdapter(private val onClick: (TarotCardModel) -> Unit) :
    ListAdapter<TarotCardModel, TarotCardAdapter.TarotCardViewHolder>( TarotCardItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarotCardViewHolder {
        val binding = TarotCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TarotCardViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: TarotCardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
         return currentList.size
    }
    class TarotCardViewHolder(
        tarotCardBinding: TarotCardBinding,
        val onClick: (TarotCardModel) -> Unit
    ) : RecyclerView.ViewHolder(tarotCardBinding.root) {
        private val binding = tarotCardBinding
        fun bind(tarotCard: TarotCardModel) {
            binding.tarotCard = tarotCard

            binding.root.setOnClickListener { onClick(tarotCard) }
        }
    }
}