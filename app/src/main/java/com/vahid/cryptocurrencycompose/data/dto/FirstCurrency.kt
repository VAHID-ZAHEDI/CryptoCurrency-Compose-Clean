package com.vahid.cryptocurrencycompose.data.dto

import com.google.gson.annotations.SerializedName

data class FirstCurrency(@SerializedName("symbol")
                         val symbol: String = "",
                         @SerializedName("name")
                         val name: String = "",
                         @SerializedName("id")
                         val id: Int = 0,
                         @SerializedName("name_fa")
                         val nameFa: String = "")