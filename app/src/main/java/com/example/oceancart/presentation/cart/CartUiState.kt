package com.example.oceancart.presentation.cart

import com.example.oceancart.data.model.StoreCart

data class CartUiState(
    val stores: List<StoreCart> = emptyList()
) {

    val totalPrice: Int
        get() = stores.sumOf { store ->
            store.items
                .filter { it.isChecked }
                .sumOf { it.price * it.quantity }
        }

    val totalItems: Int
        get() = stores.sumOf { store ->
            store.items
                .filter { it.isChecked }
                .sumOf { it.quantity }
        }
}