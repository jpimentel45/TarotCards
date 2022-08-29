package com.example.tarotcards.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.tarotcards.R
import com.example.tarotcards.databinding.FragmentTarotCardDetailBinding
import com.example.tarotcards.model.TarotCardModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TarotCardDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TarotCardDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var tarotCard: TarotCardModel

    private lateinit var binding : FragmentTarotCardDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTarotCardDetailBinding.inflate(layoutInflater)
        binding.tarotCard = tarotCard
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.apply {
            title =tarotCard.name
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TarotCardDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(tarotCard : TarotCardModel) =
            TarotCardDetailFragment().apply {
            this.tarotCard = tarotCard
            }

    }
}