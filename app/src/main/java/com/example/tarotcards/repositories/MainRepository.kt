package com.example.tarotcards.repositories

import com.example.tarotcards.model.TarotCards
import com.example.tarotcards.network.ApiResponse
import com.example.tarotcards.network.TarotApi
import com.example.tarotcards.services.offline.TarotCardsMapperImpl
import retrofit2.HttpException
import java.io.IOException

object MainRepository {

    suspend fun getCards() : ApiResponse<List<TarotCards>>{
        return try {
            val response = TarotApi.tarotRetrofitService().getCards()
            val businessList = TarotCardsMapperImpl.toJuanitoModel(response )

            ApiResponse.Success(data = businessList?: emptyList())
        } catch (e: HttpException) {
            //handles exception with the request
            ApiResponse.Error(exception = e)
        } catch (e: IOException) {
            //handles no internet exception
            ApiResponse.Error(exception = e)
        }
    }
}