package com.example.rawg.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class GameData(
  val count: Int,
  val results: List<GameResult>
){

  fun getListGame(): ArrayList<GameResult> {
    val GameList = ArrayList<GameResult>()
    for (i in 0 until 19){
      results[i].apply{
        GameList.add(GameResult(i, name, background_image))
      }
    }
    return GameList
  }
}

@Parcelize
data class GameResult(
  val index: Int,
  val name: String,
  val background_image: String
) : Parcelable
