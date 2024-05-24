package com.vahid.cryptocurrencycompose.data

import android.util.Log
import com.vahid.cryptocurrencycompose.data.dto.CurrencyPricesDTO
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class KtorApiServiceImpl @Inject constructor(
   private val httpClient: HttpClient
) : ApiService {
    override suspend fun getCurrencyPrices(): List<CurrencyPricesDTO> {
        return try {
            httpClient.get(HttpRoutes.CURRENCY_PRICES)

        } catch (e: Exception) {
            Log.d("bbb", "getCurrencyPrices: ${e.message}")
            emptyList()
        }

    }


}