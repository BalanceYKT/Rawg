package com.example.rawg.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rawg.databinding.ItemGameThinBinding
import com.example.rawg.model.GameResult

class Adapter : ListAdapter<GameResult, Adapter.Viewholder>(
  AdapterDiffCallback()
) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
    return Viewholder.from(parent)
  }

  override fun onBindViewHolder(holder: Viewholder, position: Int) {
    val item = getItem(position)
    return holder.bind(item)
  }

  class Viewholder(private val binding: ItemGameThinBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(item: GameResult){
      binding.gameResult = item
      binding.executePendingBindings()
    }

    companion object{

      fun from(parent: ViewGroup): Viewholder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGameThinBinding.inflate(layoutInflater, parent, false)
        return Viewholder(binding)
      }
    }
  }
}

class AdapterDiffCallback: DiffUtil.ItemCallback<GameResult>() {
  override fun areItemsTheSame(oldItem: GameResult, newItem: GameResult): Boolean {
    return oldItem === newItem
  }

  override fun areContentsTheSame(oldItem: GameResult, newItem: GameResult): Boolean {
    return oldItem == newItem
  }
}

