package com.vahid.cryptocurrencycompose.domain

import com.vahid.cryptocurrencycompose.data.dto.CurrencyPricesDTO

interface MainRepository {

   suspend fun getCurrencyPrices(): List<CurrencyPricesDTO>

}