package com.example.oceancart.presentation.checkout.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.oceancart.data.model.StoreCart

@Composable
fun ProductSection(store: StoreCart) {

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ){

        Column(
            modifier = Modifier.padding(16.dp)
        ){

            Text(
                text = store.storeName,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(12.dp))

            store.items.forEach { item ->

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){

                    Image(
                        painter = painterResource(item.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 12.dp)
                    ){

                        Text(item.name)

                        Text(
                            "Rp${item.price}",
                            color = Color(0xFF0D6EFD),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Text("x${item.quantity}")
                }

                Spacer(Modifier.height(12.dp))
            }
        }
    }
}