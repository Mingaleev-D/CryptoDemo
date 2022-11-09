package com.example.cryptodemo.model.successfulResponse


import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("USD")
    val uSD: USD?
)