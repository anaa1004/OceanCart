package com.example.oceancart.presentation.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.IconButton
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

@Composable
fun ChatTopBar(onBackClick: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2A7FFF))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = onBackClick) {
           Icon(
               painter = painterResource(R.drawable.back_button), contentDescription = null
           )
        }

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = "Raion Perikanan",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Online",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 12.sp
            )
        }

    }
}