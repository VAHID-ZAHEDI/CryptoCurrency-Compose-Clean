package com.vahid.cryptocurrencycompose.data.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class FirstCurrency(
    val symbol: String? = "",
    val name: String? = "",
    val id: Int? = 0,
    val nameFa: String? = ""
)