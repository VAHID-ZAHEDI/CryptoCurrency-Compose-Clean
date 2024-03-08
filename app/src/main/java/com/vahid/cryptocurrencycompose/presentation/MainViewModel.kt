package com.vahid.cryptocurrencycompose.presentation

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.vahid.cryptocurrencycompose.domain.usecases.GetCurrencyPricesUseCase
import com.vahid.cryptocurrencycompose.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val app: Application,
    val getCurrencyPricesUseCase: GetCurrencyPricesUseCase
) : AndroidViewModel(app) {
    private val _state = mutableStateOf(CryptoCurrencyListState())
    val state: State<CryptoCurrencyListState> = _state

    init {
        getCurrencyPrices()
    }

    private fun getCurrencyPrices() {
        getCurrencyPricesUseCase().onEach {
            when (it) {
                DataState.Loading ->{
                    _state.value= CryptoCurrencyListState(
                        isLoading = true,
                        cryptoCurrencies = emptyList(),
                        ""
                    )
                }
                is DataState.Success -> {
                    _state.value= CryptoCurrencyListState(
                        isLoading = false,
                        cryptoCurrencies = it.data
                    )

                }
                is DataState.Error -> {
                    _state.value= CryptoCurrencyListState(
                        isLoading = false,
                        cryptoCurrencies = emptyList(),
                        error = it.errorType
                    )

                }
            }

        }.launchIn(viewModelScope)
    }
}