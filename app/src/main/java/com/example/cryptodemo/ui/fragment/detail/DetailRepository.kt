package com.example.cryptodemo.ui.fragment.detail

import com.example.cryptodemo.base.BaseRepository
import com.example.cryptodemo.network.ApiFactory
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 10/11/2022
 */

class DetailRepository @Inject constructor(
   private val apiFactory: ApiFactory
) : BaseRepository() {

   suspend fun getDetail(
      apiKey: String,
      symbol: String
   ) = safeApiRequest {
      apiFactory.getDetail(apiKey, symbol)
   }
}