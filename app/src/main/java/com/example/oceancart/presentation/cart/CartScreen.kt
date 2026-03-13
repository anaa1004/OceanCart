package com.example.oceancart.presentation.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.oceancart.ui.theme.DarkBlue

@Composable
fun CartScreen(
    onBackClick: () -> Unit,
    onCheckOutClick: () -> Unit,
    viewModel: CartViewModel = viewModel()
) {

    val state by viewModel.uiState.collectAsState()
    val allChecked = state.stores.all { store ->
        store.items.all { it.isChecked }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column {

            CartTopBar(onBackClick = onBackClick)

            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Checkbox(
                    checked = allChecked,
                    onCheckedChange = {
                        checked -> viewModel.toggleAll(checked)
                    },
                    colors = CheckboxDefaults.colors( checkedColor = DarkBlue)
                )

                Text("Pilih semua")
            }

            LazyColumn(
                modifier = Modifier.padding(bottom = 90.dp)
            ) {

                items(state.stores) { store ->

                    StoreSection(
                        store = store,
                        onItemChecked = { itemId ->
                            viewModel.toggleItem(store.storeId, itemId)
                        },
                        onStoreChecked = { checked ->
                            viewModel.toggleStore(store.storeId, checked)
                        },
                        onIncreaseQty = { itemId ->
                            viewModel.increaseQuantity(store.storeId, itemId)
                        },
                        onDecreaseQty = { itemId ->
                            viewModel.decreaseQuantity(store.storeId, itemId)
                        }
                    )
                }
            }
        }

        CheckOutBar(
            totalPrice = state.totalPrice,
            totalItems = state.totalItems,
            modifier = Modifier.align(Alignment.BottomCenter),
            onCheckOutClick = onCheckOutClick
        )
    }
}