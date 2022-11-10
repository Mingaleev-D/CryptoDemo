package com.example.cryptodemo.model.detailResponse


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("ETH")
    val eTH: ETH?
)