package com.example.cryptodemo.ui.fragment.home

import androidx.fragment.app.viewModels
import com.example.cryptodemo.base.BaseFragment
import com.example.cryptodemo.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
   FragmentHomeBinding::inflate
) {
   override val viewModel: HomeViewModel by viewModels()

   override fun onCreateFinished() {
      TODO("Not yet implemented")
   }

   override fun initializeListeners() {
      TODO("Not yet implemented")
   }

   override fun observerEvents() {
      TODO("Not yet implemented")
   }

}