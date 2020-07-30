package com.example.rawg.repository

import com.example.rawg.DATES
import com.example.rawg.ORDERING
import com.example.rawg.model.GameData
import com.example.rawg.network.*
import retrofit2.Retrofit
import java.lang.Exception

class GameRepository(
  private val RawgApi: RawgService,
  private val responseHandler: ResponseHandler
){

  suspend fun getGames(): Resource<GameData>{
    return try{
      val response = RawgApi.getGames(DATES, ORDERING)
      return responseHandler.handleSuccess(response)
    }
    catch (e: Exception){
      responseHandler.handleException(e)
    }
  }
}

fun getGameRepository() = GameRepository(
  provideGameApi(settings()),
  ResponseHandler()
)

private fun settings(): Retrofit {
  return provideRetrofit(
    provideOkHttpClient(
      AuthInterceptor(),
      provideLoggingInterceptor()
    )
  )
}