package com.example.oceancart.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.oceancart.data.model.Product

@Composable

fun ProductHorizontalList(
    products: List<Product>,
    onProdukDetailClick : (Product) -> Unit
) {

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(products) {
            product -> ProductCard(
            product = product,
            onClick = { onProdukDetailClick(product) }
        )
        }
    }
}