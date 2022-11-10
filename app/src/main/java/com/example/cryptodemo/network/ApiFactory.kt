package com.example.cryptodemo.network

import com.example.cryptodemo.model.detailResponse.DetailResponse
import com.example.cryptodemo.model.successfulResponse.CryptoResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * @author : Mingaleev D
 * @data : 9/11/2022
 */

//https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?limit=10

interface ApiFactory {

   @GET("v1/cryptocurrency/listings/latest")
   suspend fun getData(
      @Header("X-CMC_PRO_API_KEY") apiKey: String,
      @Query("limit") limit:String
   ):CryptoResponse

   @GET("v1/cryptocurrency/info")
   suspend fun getDetail(
      @Header("X-CMC_PRO_API_KEY") apiKey: String,
      @Query("symbol") symbol:String
   ):DetailResponse
}