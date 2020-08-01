package com.example.rawg.ui.main

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.rawg.model.GameData

class Adapter(private val ItemList: GameData) : RecyclerView.Adapter<Adapter.ViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
    TODO("Not yet implemented")
  }

  override fun getItemCount() = ItemList.count

  override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
    TODO("Not yet implemented")
  }

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    lateinit var imageView: ImageView
  }
}