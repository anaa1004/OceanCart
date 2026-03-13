package com.example.oceancart.presentation.checkout.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.R
import com.example.oceancart.data.model.Address

@Composable
fun AddressSection(
    address: Address?,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(R.drawable.icon_location),
                contentDescription = null,
                tint = Color.Unspecified
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Alamat Pengiriman",
                    fontWeight = FontWeight.Bold
                )

                if (address != null) {

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "${address.name} | ${address.phone}",
                        fontSize = 14.sp
                    )

                    Text(
                        text = address.address,
                        fontSize = 13.sp,
                        color = Color.Gray
                    )

                } else {

                    Text(
                        text = "Pilih alamat pengiriman",
                        color = Color.Gray
                    )
                }
            }

            Icon(
                painter = painterResource(R.drawable.icon_more),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}