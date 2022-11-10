package com.example.cryptodemo.ui.fragment.home

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.cryptodemo.base.BaseFragment
import com.example.cryptodemo.databinding.FragmentHomeBinding
import com.example.cryptodemo.model.successfulResponse.Data
import com.example.cryptodemo.ui.fragment.adapter.HomeAdapter
import com.example.cryptodemo.ui.fragment.adapter.ItemClickListener
import com.example.cryptodemo.utils.Constants.API_KEY
import com.example.cryptodemo.utils.Constants.LIMIT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
   FragmentHomeBinding::inflate
) {
   override val viewModel: HomeViewModel by viewModels()

   override fun onCreateFinished() {
      viewModel.getData(API_KEY, LIMIT)
   }

   override fun initializeListeners() {
      //TODO("Not yet implemented")
   }

   override fun observerEvents() {
      with(viewModel) {
         cryptoResponse.observe(viewLifecycleOwner) { cryptoResponse ->
            cryptoResponse?.let {
               it.data?.let { it1 -> setRecycler(it1) }
            }
         }
         isLoading.observe(viewLifecycleOwner) {
            handleViews(it)
         }
         onError.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Error $it", Toast.LENGTH_SHORT).show()
         }
      }
   }

   private fun setRecycler(data: List<Data>) {
      val mAdapter = HomeAdapter(object : ItemClickListener {
         override fun onItemClick(coin: Data) {

         }

      })
      binding.homeRv.adapter = mAdapter
      mAdapter.setList(data)
   }

   private fun handleViews(isLoading: Boolean = false) {
      binding.homeRv.isVisible = !isLoading
      binding.progressBar.isVisible = isLoading
   }

}