package com.example.oceancart.presentation.checkout.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckoutBottomBar(
    totalProduct:Int,
    totalPrice:Int,
    onPay:()->Unit,
    modifier: Modifier = Modifier
){

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        Column(
            modifier = Modifier.weight(1f)
        ){

            Text("$totalProduct Produk")

            Text(
                "Rp$totalPrice",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0D6EFD)
            )
        }

        Button(
            onClick = onPay,
            shape = RoundedCornerShape(50)
        ){
            Text("Bayar")
        }
    }
}