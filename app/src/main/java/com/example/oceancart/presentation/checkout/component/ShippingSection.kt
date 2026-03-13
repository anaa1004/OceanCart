package com.example.oceancart.presentation.checkout.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.oceancart.data.model.ShippingOption

@Composable
fun ShippingSection(
    shipping: ShippingOption?,
    onClick:()->Unit
){

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() }
    ){

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Column(
                modifier = Modifier.weight(1f)
            ){

                Text(
                    "Ekspedisi Pengiriman",
                    fontWeight = FontWeight.Bold
                )

                shipping?.let{

                    Text(it.name)

                    Text(
                        "Estimasi ${it.estimation}",
                        color = Color.Gray
                    )
                }
            }

            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight,null)
        }
    }
}