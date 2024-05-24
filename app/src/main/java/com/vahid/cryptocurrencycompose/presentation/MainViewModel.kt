package com.vahid.cryptocurrencycompose.presentation

import android.app.Application
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vahid.cryptocurrencycompose.domain.usecases.GetCurrencyPricesUseCase
import com.vahid.cryptocurrencycompose.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val getCurrencyPricesUseCase: GetCurrencyPricesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CryptoCurrencyListState())
    val state: State<CryptoCurrencyListState> = _state

    init {
        getCurrencyPrices()
    }

    private fun getCurrencyPrices() {
        getCurrencyPricesUseCase().onEach {
            when (it) {
                DataState.Loading ->{
                    Log.d("hhh", "getCurrencyPrices: loading")
                    _state.value= CryptoCurrencyListState(
                        isLoading = true,
                        cryptoCurrencies = emptyList(),
                        ""
                    )
                }
                is DataState.Success -> {
                    Log.d("hhh", "getCurrencyPrices: ${it.data}")

                    _state.value= CryptoCurrencyListState(
                        isLoading = false,
                        cryptoCurrencies = it.data
                    )

                }
                is DataState.Error -> {
                    Log.d("hhh", "getCurrencyPrices: ${it.errorType}")

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