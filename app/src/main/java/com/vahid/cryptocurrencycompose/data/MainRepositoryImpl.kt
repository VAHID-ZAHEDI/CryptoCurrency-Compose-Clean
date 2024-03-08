package com.vahid.cryptocurrencycompose.data

import com.vahid.cryptocurrencycompose.data.dto.CurrencyPricesDTO
import com.vahid.cryptocurrencycompose.domain.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val apiService: ApiService) : MainRepository {
    override suspend fun getCurrencyPrices(): List<CurrencyPricesDTO> {
        return apiService.getCurrencyPrices()
    }
}