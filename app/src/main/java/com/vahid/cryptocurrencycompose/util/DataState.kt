package com.vahid.cryptocurrencycompose.util

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val errorType: String) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}