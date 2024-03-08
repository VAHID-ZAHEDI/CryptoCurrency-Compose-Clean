package com.vahid.cryptocurrencycompose.domain.model

import com.google.gson.annotations.SerializedName
import com.vahid.cryptocurrencycompose.data.dto.MarketsItem

data class CurrencyPrices(

    val symbol: String = "",

    val nameFa: String = "",

    val changePercent: String = "",

    val priceInUsdt: String = "",

    val name: String = "",

    val id: Int = 0
)