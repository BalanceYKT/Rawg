package com.example.rawg.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rawg.model.GameData
import com.example.rawg.model.GameResult
import com.example.rawg.repository.getGameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragmentViewModel : ViewModel() {

  private val _gameListData = MutableLiveData<ArrayList<GameResult>>()
  val gameListData: LiveData<ArrayList<GameResult>>
    get() = _gameListData

  init {
    loadData()
  }

  private fun loadData() {
    CoroutineScope(Dispatchers.IO).launch {
      val response = getGameRepository().getGames()
      withContext(Dispatchers.Main){
        setData(response.data!!)
      }
    }
  }

  private fun setData(response: GameData){
    _gameListData.value = response.getListGame()
  }


}