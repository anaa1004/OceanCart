package com.example.oceancart.ui.components.profilePage

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LogoutButton() {

    Row(
        modifier = Modifier
            .padding(20.dp)
    ) {

        Icon(
            Icons.AutoMirrored.Filled.Logout,
            contentDescription = null,
            tint = Color.Red
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            "Keluar",
            color = Color.Red
        )
    }
}