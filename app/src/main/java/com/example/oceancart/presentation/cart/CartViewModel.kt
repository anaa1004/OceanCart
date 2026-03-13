package com.example.oceancart.presentation.cart

import androidx.lifecycle.ViewModel
import com.example.oceancart.data.model.CartData
import com.example.oceancart.data.model.StoreCart
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        CartUiState(CartData.cart)
    )
    private val _stores = MutableStateFlow<List<StoreCart>>(CartData.cart)
    val stores: StateFlow<List<StoreCart>> = _stores
    val uiState: StateFlow<CartUiState> = _uiState

    fun toggleItem(storeId: Int, itemId: Int) {

        val updatedStores = _uiState.value.stores.map { store ->

            if (store.storeId != storeId) return@map store

            val updatedItems = store.items.map { item ->
                if (item.id == itemId) {
                    item.copy(isChecked = !item.isChecked)
                } else item
            }

            store.copy(items = updatedItems)
        }

        _uiState.value = CartUiState(updatedStores)
    }

    fun toggleStore(storeId: Int, isChecked: Boolean) {

        val updatedStores = _uiState.value.stores.map { store ->

            if (store.storeId != storeId) return@map store

            val updatedItems = store.items.map {
                it.copy(isChecked = isChecked)
            }

            store.copy(items = updatedItems)
        }

        _uiState.value = CartUiState(updatedStores)
    }

    fun toggleAll(isChecked: Boolean) {

        val updatedStores = _uiState.value.stores.map { store ->

            val updatedItems = store.items.map {
                it.copy(isChecked = isChecked)
            }

            store.copy(items = updatedItems)
        }

        _uiState.value = CartUiState(updatedStores)
    }

    fun increaseQuantity(storeId: Int, itemId: Int) {

        val updatedStores = _uiState.value.stores.map { store ->

            if (store.storeId != storeId) return@map store

            val updatedItems = store.items.map { item ->
                if (item.id == itemId) {
                    item.copy(quantity = item.quantity + 1)
                } else item
            }

            store.copy(items = updatedItems)
        }

        _uiState.value = CartUiState(updatedStores)
    }

    fun decreaseQuantity(storeId: Int, itemId: Int) {

        val updatedStores = _uiState.value.stores.map { store ->

            if (store.storeId != storeId) return@map store

            val updatedItems = store.items.map { item ->
                if (item.id == itemId) {

                    val newQty = (item.quantity - 1).coerceAtLeast(1)

                    item.copy(quantity = newQty)
                } else item
            }

            store.copy(items = updatedItems)
        }

        _uiState.value = CartUiState(updatedStores)
    }

    fun getCheckedStores(): List<StoreCart> {
        return _stores.value.mapNotNull { store ->

            val checkedItems = store.items.filter { it.isChecked }

            if (checkedItems.isNotEmpty()) {
                store.copy(items = checkedItems)
            } else {
                null
            }
        }
    }


}