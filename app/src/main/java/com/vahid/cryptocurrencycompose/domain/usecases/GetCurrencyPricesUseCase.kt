package com.vahid.cryptocurrencycompose.domain.usecases

import com.vahid.cryptocurrencycompose.data.dto.toCurrencyPrices
import com.vahid.cryptocurrencycompose.domain.MainRepository
import com.vahid.cryptocurrencycompose.util.DataState
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCurrencyPricesUseCase @Inject constructor(private val mainRepository: MainRepository) {
    operator fun invoke() = flow {
        emit(DataState.Loading)
        try {
            emit(DataState.Success(mainRepository.getCurrencyPrices().map {
                it.toCurrencyPrices()
            }))

        } catch (e: Exception) {
            emit(DataState.Error("ERROR"))

        }
    }
}