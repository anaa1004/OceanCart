package com.example.oceancart.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.oceancart.data.model.Product
import com.example.oceancart.data.model.productList

@Composable

fun CategoryProductScreen(
    category: String,
    onProdukDetailClick: (Product) -> Unit = {}) {

    val filteredProducts = productList.filter {
        it.category == category
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(filteredProducts) {
            product -> ProductCard(
            product = product,
            onClick = { onProdukDetailClick(product) })
        }
    }
}