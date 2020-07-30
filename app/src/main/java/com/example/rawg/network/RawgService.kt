package com.example.rawg.network

import com.example.rawg.model.GameData
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgService{

  @GET("games")
  suspend fun getGames(@Query("dates") date: String,
                       @Query("ordering") ordering: String): GameData
}