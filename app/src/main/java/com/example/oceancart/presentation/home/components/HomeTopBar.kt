package com.example.oceancart.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.oceancart.ui.theme.DarkBlue

@Composable

fun HomeTopBar(
    onChatClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(R.drawable.icons_logo2),
            contentDescription = null,
            tint = Color.Unspecified
        )

        Row{
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(R.drawable.icons_notification),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
            IconButton(onClick = onChatClick) {
                Icon(
                    painter = painterResource(R.drawable.icons_chat),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }
    }
}