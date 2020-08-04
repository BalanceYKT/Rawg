package com.example.rawg.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class GameData(
  val count: Int,
  val results: List<GameResult>
){

  fun getListGame(): ArrayList<GameResult> {
    return ArrayList<GameResult>()
  }
}

@Parcelize
data class GameResult(
  val id: Int,
  val name: String,
  val background_image: String
) : Parcelable