package com.vahid.cryptocurrencycompose.data

import com.vahid.cryptocurrencycompose.data.dto.CurrencyPricesDTO
import retrofit2.http.GET

interface ApiService {
    suspend fun getCurrencyPrices(): List<CurrencyPricesDTO>

}