package com.example.cryptodemo.ui.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.cryptodemo.R
import com.example.cryptodemo.base.BaseFragment
import com.example.cryptodemo.databinding.FragmentDetailsBinding


class DetailsFragment : BaseFragment<FragmentDetailsBinding, DetailsViewModel>(
   FragmentDetailsBinding::inflate
) {
   override val viewModel: DetailsViewModel by viewModels()
   private val args by navArgs<DetailsFragmentArgs>()

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