package com.example.oceancart.presentation.home.components

import android.R.attr.category
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable

fun CategoryRow() {

    val categories = listOf("Ikan", "Cumi", "Udang", "Kepiting")

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(categories) {
            category -> Card {
                Text(
                    text = category,
                    modifier = Modifier.padding(16.dp)
                )
        }
        }
    }
}