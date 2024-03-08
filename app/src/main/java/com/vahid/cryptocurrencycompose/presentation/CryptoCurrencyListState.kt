package com.vahid.cryptocurrencycompose.presentation

import com.vahid.cryptocurrencycompose.domain.model.CurrencyPrices

data class CryptoCurrencyListState(
    val isLoading: Boolean = false,
    val cryptoCurrencies: List<CurrencyPrices> = emptyList(),
    val error: String = ""
)