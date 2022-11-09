package com.example.cryptodemo.ui.fragment.home

import com.example.cryptodemo.base.BaseRepository
import com.example.cryptodemo.network.ApiFactory
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 9/11/2022
 */

class HomeRepository @Inject constructor(
   private val apiFactory: ApiFactory
) : BaseRepository() {

   suspend fun getData(
      apiKey: String,
      limit: String
   ) = safeApiRequest {
      apiFactory.getData(apiKey = apiKey, limit = limit)
   }
}