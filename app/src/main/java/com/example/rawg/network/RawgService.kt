package com.example.rawg.network

import retrofit2.http.GET

interface RawgService{
  @GET("games")
  suspend fun getGames()
}