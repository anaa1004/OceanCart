package com.example.oceancart.presentation.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BuyerBubble(
    message: String,
    time: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {

        Box(
            modifier = Modifier
                .background(
                    Color(0xFF1F7AA8),
                    RoundedCornerShape(12.dp)
                )
                .padding(12.dp)
                .widthIn(max = 260.dp)
        ) {

            Column {

                Text(
                    message,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    time,
                    fontSize = 11.sp,
                    color = Color.White.copy(alpha = 0.7f)
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(10.dp))
}