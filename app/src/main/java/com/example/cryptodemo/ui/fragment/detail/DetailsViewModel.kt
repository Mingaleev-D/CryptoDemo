package com.example.cryptodemo.ui.fragment.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptodemo.model.detailResponse.DetailResponse
import com.example.cryptodemo.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 10/11/2022
 */
@HiltViewModel
class DetailsViewModel @Inject constructor(
   private val repository: DetailRepository
) : ViewModel() {

   val detailResponse: MutableLiveData<DetailResponse?> = MutableLiveData()
   val isLoading: MutableLiveData<Boolean> = MutableLiveData(true)
   val onError: MutableLiveData<String?> = MutableLiveData()

   fun getDetail(
      apiKey: String,
      symbol: String
   ) = viewModelScope.launch {
      isLoading.value = true
      when (val request = repository.getDetail(apiKey, symbol)) {
         is NetworkResult.Success ->{
            detailResponse.value = request.data
            isLoading.value = false
         }
         is NetworkResult.Error -> {
            onError.value = request.message
            isLoading.value = false
         }
         else ->{}
      }
   }
}