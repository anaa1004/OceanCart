package com.example.oceancart.presentation.checkout.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PaymentSection(
    selected:String,
    onSelect:(String)->Unit
){

    Card(
        modifier = Modifier
            .padding(16.dp)
    ){

        Column(
            modifier = Modifier.padding(16.dp)
        ){

            Text(
                "Metode Pembayaran",
                fontWeight = FontWeight.Bold
            )

            Row(verticalAlignment = Alignment.CenterVertically){

                Text("Tunai")

                Spacer(Modifier.weight(1f))

                Checkbox(
                    checked = selected == "Tunai",
                    onCheckedChange = {
                        onSelect("Tunai")
                    }
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically){

                Text("QRIS")

                Spacer(Modifier.weight(1f))

                Checkbox(
                    checked = selected == "QRIS",
                    onCheckedChange = {
                        onSelect("QRIS")
                    }
                )
            }
        }
    }
}