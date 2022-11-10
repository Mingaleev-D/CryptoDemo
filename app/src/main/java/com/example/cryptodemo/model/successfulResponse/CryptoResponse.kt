package com.example.cryptodemo.model.successfulResponse


import com.google.gson.annotations.SerializedName

data class CryptoResponse(
    @SerializedName("data")
    val `data`: List<Data>?,
    @SerializedName("status")
    val status: Status?
)