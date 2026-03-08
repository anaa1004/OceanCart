package com.example.oceancart.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.oceancart.R
import com.example.oceancart.data.model.Product

@Composable

fun RecommendationSection(
    products: List<Product>
) {

    Column() {
        SectionHeader(
            title = "Rekomendasi",
            icon = R.drawable.icon_rekomendasi
        )

        Spacer(modifier = Modifier.height(12.dp))

        ProductHorizontalList(products)
    }
}