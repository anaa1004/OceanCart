package com.example.oceancart.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.oceancart.R

@Composable

fun NavBar(
    modifier: Modifier = Modifier.Companion
) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.icons_home),
                    contentDescription = "Home"
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.icons_search),
                    contentDescription = "Search"
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.icons_cart),
                    contentDescription = "Cart"
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.icons_order),
                    contentDescription = "Order"
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.icons_group),
                    contentDescription = "Group"
                )
            }

        }
    }
}