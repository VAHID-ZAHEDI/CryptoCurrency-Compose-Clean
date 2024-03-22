package com.vahid.cryptocurrencycompose.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.vahid.cryptocurrencycompose.R
import com.vahid.cryptocurrencycompose.domain.model.CurrencyPrices
import com.vahid.cryptocurrencycompose.presentation.CryptoListScreen
import com.vahid.cryptocurrencycompose.presentation.ui.theme.MyApplicationTheme
import com.vahid.cryptocurrencycompose.presentation.ui.theme.Pink_start
import com.vahid.cryptocurrencycompose.presentation.ui.theme.gradient_end_2
import com.vahid.cryptocurrencycompose.presentation.ui.theme.gradient_end_3
import com.vahid.cryptocurrencycompose.presentation.ui.theme.gradient_end_4
import com.vahid.cryptocurrencycompose.presentation.ui.theme.gradient_start_2
import com.vahid.cryptocurrencycompose.presentation.ui.theme.gradient_start_3
import com.vahid.cryptocurrencycompose.presentation.ui.theme.gradient_start_4
import com.vahid.cryptocurrencycompose.presentation.ui.theme.orange_end
import com.vahid.cryptocurrencycompose.util.PreviewProvider

@Composable
fun CryptoCurrencyItem(
    position: Int,
    currencyPrices: CurrencyPrices
) {
    val colors = listOf(
        Pair(Pink_start, orange_end),
        Pair(gradient_start_2, gradient_end_2),
        Pair(gradient_start_3, gradient_end_3),
        Pair(gradient_start_4, gradient_end_4),
    )
    Spacer(modifier = Modifier.padding(16.dp))
    Card(

        modifier = Modifier
            .height(90.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8)

    ) {
        var index = randomColor(colors)
        val color = colors[position]
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(color.first, color.second)
                    )
                )
        ) {


            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.padding(8.dp))

//                val screenWidth = Offset.Unspecified.x
//
//                Box(
//                    modifier = Modifier
//                        .clip(CircleShape)
//                        .size((screenWidth / 2).dp)
//                        .background(Color.White)
//                        .alpha(0.1f)
//                )

                AsyncImage(
                    model = currencyPrices.imageUrl,
                    contentDescription = "icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .alpha(0.5f)

                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = currencyPrices.symbol,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontFamily = FontFamily(Font(R.font.monaco))
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = currencyPrices.name,
                    color = Color.White,
                    modifier = Modifier.alpha(0.5f),
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.shadow(4.dp),
                    text = currencyPrices.priceInUsdt,
                    color = Color.White,
                    fontSize = 12.sp
                )

            }
            Spacer(modifier = Modifier.width(300.dp))
//            Box(
//                modifier = Modifier
//                    .alpha(0.05f)
//                    .clip(CircleShape)
//                    .background(Color.White)
//                    .requiredSize(160.dp)
//                    .offset(500.dp)
//            )
//            Box(
//                modifier = Modifier
//                    .alpha(0.05f)
//                    .clip(CircleShape)
//                    .background(Color.Red)
//                    .requiredSize(100.dp)
//                    .offset(10.dp)
//            )


        }


    }
}

@Composable
private fun randomColor(colors: List<Pair<Color, Color>>) =
    (0..colors.lastIndex).shuffled()

@Composable
@Preview
fun GreetingPreview() {
    MyApplicationTheme {
        Row {

            CryptoCurrencyItem(
                0,
                currencyPrices = CurrencyPrices(
                    "BTC", "بیت کوین", "", "", "", ""
                )
            )
        }
    }
}

