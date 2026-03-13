package com.example.oceancart.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HistorySection() {

    val history = listOf(
        "Gurita Segar",
        "Kerang Hijau",
        "Tuna fillet segar",
        "Cumi-Cumi segar"
    )

    Column {

        Text(
            text = "Riwayat",
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2A7FFF)
        )

        Spacer(modifier = Modifier.height(8.dp))

        history.forEach {

            HistoryItem(it)
        }
    }
}