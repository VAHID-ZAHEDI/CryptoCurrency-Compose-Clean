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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.vahid.cryptocurrencycompose.R
import com.vahid.cryptocurrencycompose.domain.model.CurrencyPrices
import com.vahid.cryptocurrencycompose.presentation.ui.theme.Pink_start
import com.vahid.cryptocurrencycompose.presentation.ui.theme.orange_end

@Composable
fun CryptoCurrencyItem(
    currencyPrices: CurrencyPrices
) {
    Spacer(modifier = Modifier.padding(8.dp))
    Card(

        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8)

    ) {


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Pink_start, orange_end)
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

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
                    model = currencyPrices.symbol,
                    contentDescription = "icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .alpha(0.5f)

                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "BTC",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontFamily = FontFamily(Font(R.font.monaco))
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Bitcoin",
                    color = Color.White,
                    modifier = Modifier.alpha(0.5f),
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "2000$",
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