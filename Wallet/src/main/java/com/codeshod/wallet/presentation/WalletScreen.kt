package com.codeshod.wallet.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codeshod.design_systems.AppDrawables
import com.codeshod.design_systems.HEADER_CURVE_HEIGHT_WITHOUT_TOPBAR
import com.codeshod.design_systems.theme.Black
import com.codeshod.design_systems.theme.White
import com.codeshod.design_systems.views.CardView
import com.codeshod.design_systems.views.TextView

@Composable
fun WalletScreen() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 12.dp)
    ) {
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(HEADER_CURVE_HEIGHT_WITHOUT_TOPBAR)
            ) {
                TextView(
                    text = "Total Balance",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                TextView(
                    text = "$ 2548.00",
                    color = Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        items(5) { item ->
            WalletItem(item)
        }
    }
}

@Composable
private fun WalletItem(item: Int) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        CardView {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = AppDrawables.wallet),
                    contentDescription = "",
                    modifier = Modifier
                        .size(64.dp)
                        .background(
                            color = White,
                            shape = CircleShape
                        )
                        .padding(12.dp)
                )

                Spacer(modifier = Modifier.width(24.dp))

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextView(text = "Bank Alfalah")
                    TextView(text = "Bank")
                }
            }
        }
    }
}