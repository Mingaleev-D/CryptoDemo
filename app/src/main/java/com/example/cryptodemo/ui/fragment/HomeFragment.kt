package com.example.cryptodemo.ui.fragment

import androidx.fragment.app.viewModels
import com.example.cryptodemo.base.BaseFragment
import com.example.cryptodemo.databinding.FragmentHomeBinding
import com.example.cryptodemo.ui.viewmodel.HomeViewModel


class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(
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