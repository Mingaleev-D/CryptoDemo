package com.example.cryptodemo.model.detailResponse


import com.google.gson.annotations.SerializedName

data class ContractAddres(
    @SerializedName("contract_address")
    val contractAddress: String?,
    @SerializedName("platform")
    val platform: Platform?
)