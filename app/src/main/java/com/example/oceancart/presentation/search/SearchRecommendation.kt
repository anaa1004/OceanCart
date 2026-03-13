package com.example.oceancart.presentation.search

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun RecommendationSection() {

    val items = listOf(
        "Kepiting Jumbo",
        "Salmon Fillet",
        "Cumi-cumi",
        "Kerang 1 kg",
        "Tuna Segar",
        "Salmon Murah"
    )

    Column {

        Text(
            text = "Rekomendasi",
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2A7FFF)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {

            items.forEach {

                RecommendationChip(it)
            }
        }
    }
}