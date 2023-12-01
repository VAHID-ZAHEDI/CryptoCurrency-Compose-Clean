package com.vahid.cryptocurrencycompose.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.vahid.cryptocurrencycompose.R
import com.vahid.cryptocurrencycompose.presentation.ui.theme.Pink80
import com.vahid.cryptocurrencycompose.presentation.ui.theme.Pink_start
import com.vahid.cryptocurrencycompose.presentation.ui.theme.orange_end
import com.vahid.cryptocurrencycompose.util.PreviewProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

@Composable
fun CryptoListScreen() {

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

                AsyncImage(
                    model = "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1696501400",
                    contentDescription = "icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(0.dp)
                        .clip(CircleShape)
                        .alpha(0.5f)

                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "BTC",
                    color = Color.White,
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
            Box(
                modifier = Modifier
                    .alpha(0.05f)
                    .clip(CircleShape)
                    .background(Color.White)
                    .requiredSize(160.dp)
                    .offset(500.dp)
            )
            Box(
                modifier = Modifier
                    .alpha(0.05f)
                    .clip(CircleShape)
                    .background(Color.Red)
                    .requiredSize(100.dp)
                    .offset(10.dp)
            )
        }


    }


}

@PreviewProvider
@Composable
fun ItemPreview() {
    Row {
        Column(modifier = Modifier.padding(4.dp)) {
            CryptoListScreen()

        }
    }
}