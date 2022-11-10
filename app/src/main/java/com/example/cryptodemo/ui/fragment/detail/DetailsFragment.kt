package com.example.cryptodemo.ui.fragment.detail

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.cryptodemo.base.BaseFragment
import com.example.cryptodemo.databinding.FragmentDetailsBinding
import com.example.cryptodemo.model.detailResponse.DetailResponse
import com.example.cryptodemo.model.detailResponse.ETH
import com.example.cryptodemo.utils.Constants.API_KEY
import com.example.cryptodemo.utils.loadImage
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONArray
import org.json.JSONObject


@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding, DetailsViewModel>(
   FragmentDetailsBinding::inflate
) {
   override val viewModel: DetailsViewModel by viewModels()
   private val args by navArgs<DetailsFragmentArgs>()

   override fun onCreateFinished() {
      viewModel.getDetail(API_KEY, args.symbol)
   }

   override fun initializeListeners() {
      //TODO("Not yet implemented")
   }

   override fun observerEvents() {
      with(viewModel) {
         detailResponse.observe(viewLifecycleOwner) {
            parseData(it)
         }
         isLoading.observe(viewLifecycleOwner) {
            handleViews(it)
         }
         onError.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Error $it", Toast.LENGTH_SHORT).show()
         }
      }
   }

   private fun parseData(it: DetailResponse?) {
      val gson = Gson()
      val json = gson.toJson(it?.data)
      val jsonObject = JSONObject(json)
      val jsonArray = jsonObject[args.symbol] as JSONArray

      val coin = gson.fromJson(jsonArray.getJSONObject(0).toString(), ETH::class.java)

      coin?.let {
         with(binding) {
            detailImageView2.loadImage(it.logo)
            detailTitle.text = it.name
            detailSymbol.text = it.symbol
            description.text = it.description
         }
      }
   }

   private fun handleViews(isLoading: Boolean = false) {
      binding.detailGroup.isVisible = !isLoading
      binding.progressBar2.isVisible = isLoading
   }

}