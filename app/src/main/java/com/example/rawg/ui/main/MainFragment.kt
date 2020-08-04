package com.example.rawg.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.rawg.R
import com.example.rawg.databinding.ItemGamesHorizontalBinding

class MainFragment : Fragment() {

  private val viewModel: MainFragmentViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    val binding: ItemGamesHorizontalBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

    binding.viewModel = viewModel
    binding.lifecycleOwner = this

    val adapter = Adapter()
    binding.recyclerView.adapter = adapter
    viewModel.gameListData.observe(viewLifecycleOwner, Observer {
      it?.let { adapter.submitList(it) }
    })

    return binding.root
    //return inflater.inflate(R.layout.fragment_main, container, false)
  }


}