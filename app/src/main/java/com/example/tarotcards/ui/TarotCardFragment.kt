package com.example.tarotcards.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tarotcards.MainActivity
import com.example.tarotcards.R
import com.example.tarotcards.databinding.FragmentTarotCardBinding
import com.example.tarotcards.repositories.TarotCardsRepository
import com.example.tarotcards.tarot.TarotCardAdapter
import com.example.tarotcards.tarot.TarotViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TarotCardFragment : Fragment() {

    private var _binding : FragmentTarotCardBinding? = null

    private val binding get() =  _binding!!
    private lateinit var viewModel: TarotViewModel
    private var repo: TarotCardsRepository? = null
    private lateinit var adapter: TarotCardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTarotCardBinding.inflate(layoutInflater)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.apply {
            title = "Tarot Cards"
        }
        adapter = TarotCardAdapter{
            activity?.supportFragmentManager?.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, TarotCardDetailFragment.newInstance(it))
                addToBackStack(null)
            }
        }
        repo = activity?.application?.let { TarotCardsRepository(it) }
        viewModel = ViewModelProvider(this)[TarotViewModel::class.java]
        binding.rvTarotCards.apply {
            layoutManager = GridLayoutManager(this@TarotCardFragment.context, 3)
            itemAnimator = DefaultItemAnimator()
            adapter = this@TarotCardFragment.adapter
        }
        viewModel.list.observe(viewLifecycleOwner){
            lifecycleScope.launch(Dispatchers.Unconfined) {
                repo?.insertAll(it ?: emptyList())
            }
        }
        repo?.getAllTarotCards()?.observe(viewLifecycleOwner){
            if(it.isEmpty()){
                viewModel.getTarotCards()
            }else{
                adapter.submitList(it?.toMutableList())
            }
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TarotCardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() : TarotCardFragment =
            TarotCardFragment()
    }
}