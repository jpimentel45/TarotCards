package com.example.tarotcards.tarot

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tarotcards.model.TarotCardModel
import com.example.tarotcards.network.ApiResponse
import com.example.tarotcards.network.TarotApi
import com.example.tarotcards.repositories.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TarotViewModel : ViewModel(){
    private val _list = MutableLiveData<List<TarotCardModel>?>(emptyList())
    val list: LiveData<List<TarotCardModel>?> = _list
 fun getTarotCards(){
    viewModelScope.launch(Dispatchers.IO){
        val listResult = TarotApi.tarotRetrofitService().getCards()
        val response = MainRepository.getCards()
        if(response is ApiResponse.Success){
            _list.postValue(response.data)

            for(card in response.data){
                Log.i(this@TarotViewModel.javaClass.name, card.toString())
            }
        }

        if(response is ApiResponse.Error){
            //error
        }
    }
}
}