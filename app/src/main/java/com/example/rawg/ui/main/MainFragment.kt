package com.example.rawg.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.rawg.R
import com.example.rawg.databinding.FragmentMainBinding

class MainFragment : Fragment() {

  companion object {
    fun newInstance() = MainFragment()
  }

  private val viewModel: MainFragmentViewModel by viewModels()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View {

    val binding: FragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
    binding.viewModel = viewModel
    binding.lifecycleOwner = this



    return binding.root
    //return inflater.inflate(R.layout.fragment_main, container, false)
  }


}