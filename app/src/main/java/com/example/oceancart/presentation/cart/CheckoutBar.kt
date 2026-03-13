package com.example.oceancart.presentation.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.ui.theme.DarkBlue

@Composable
fun CheckOutBar(
    totalPrice: Int,
    totalItems: Int,
    modifier: Modifier = Modifier,
    onCheckOutClick: () -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text("$totalItems Produk")

            Text(
                "Rp$totalPrice",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = DarkBlue
            )
        }

        Button(
            onClick = onCheckOutClick
        ) {
            Text("Beli Sekarang")
        }
    }
}