package com.vahid.cryptocurrencycompose.presentation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsActions.Expand
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vahid.cryptocurrencycompose.presentation.component.CardListState
import com.vahid.cryptocurrencycompose.presentation.component.CryptoCurrencyItem

@Composable
fun CryptoListScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.state.value


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        } else  {
            val cardListState = remember { CardListState(state.cryptoCurrencies.toMutableStateList()) }
            val state2 = rememberLazyListState()
            val randomNumbers = (0..3).shuffled()

            LazyColumn(
                state = state2,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                itemsIndexed(
                    items = cardListState.list,
                    key = { index, item -> state.cryptoCurrencies[index].id })
                { index, currencyPrice ->
                    val randomNumber = randomNumbers[index % randomNumbers.size]

                    CryptoCurrencyItem(
                        index = randomNumber,
                        currencyPrices = currencyPrice,
                        state = {
                            cardListState.onSelected(it, currencyPrice)
                        },
                        isExpanded = currencyPrice.isExpanded


                    )

                }
            }
        }
    }


}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ItemPreview() {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            CryptoListScreen()

        }
    }
}