package com.vahid.cryptocurrencycompose.presentation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.vahid.cryptocurrencycompose.R
import com.vahid.cryptocurrencycompose.presentation.component.CryptoCurrencyItem
import com.vahid.cryptocurrencycompose.presentation.ui.theme.Pink_start
import com.vahid.cryptocurrencycompose.presentation.ui.theme.background
import com.vahid.cryptocurrencycompose.presentation.ui.theme.gradient_end_2
import com.vahid.cryptocurrencycompose.presentation.ui.theme.gradient_end_3
import com.vahid.cryptocurrencycompose.presentation.ui.theme.gradient_end_4
import com.vahid.cryptocurrencycompose.presentation.ui.theme.gradient_start_2
import com.vahid.cryptocurrencycompose.presentation.ui.theme.gradient_start_3
import com.vahid.cryptocurrencycompose.presentation.ui.theme.gradient_start_4
import com.vahid.cryptocurrencycompose.presentation.ui.theme.orange_end
import kotlin.math.log

@Composable
fun CryptoListScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val colors = listOf(
        Pair(Pink_start, orange_end),
        Pair(gradient_start_2, gradient_end_2),
        Pair(gradient_start_3, gradient_end_3),
        Pair(gradient_start_4, gradient_end_4),
    )
    val randomNumbers = (0..3).shuffled()
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        itemsIndexed(state.cryptoCurrencies) { index, currencyPrices ->
            val randomNumber = randomNumbers[index % randomNumbers.size]
            CryptoCurrencyItem(
                position = randomNumber,
                currencyPrices = currencyPrices
            )

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