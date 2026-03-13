package com.example.oceancart.presentation.checkout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.oceancart.presentation.cart.CartViewModel
import com.example.oceancart.presentation.checkout.component.*

@Composable
fun CheckoutScreen(
    navController: NavController,
    onBackClick: () -> Unit
) {

    val cartViewModel: CartViewModel = viewModel()
    val checkoutViewModel: CheckoutViewModel = viewModel()

    val checkoutState by checkoutViewModel.state.collectAsState()

    val selectedStores = cartViewModel.getCheckedStores()

    val totalItems = selectedStores.sumOf { it.items.sumOf { item -> item.quantity } }
    val totalPrice = selectedStores.sumOf { it.items.sumOf { item -> item.price * item.quantity } }

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 90.dp)
        ) {

            item { CheckoutTopBar(onBackClick) }

            item {
                AddressSection(
                    address = checkoutState.address,
                    onClick = { navController.navigate("selectAddress") }
                )
            }

            items(selectedStores) { store ->
                ProductSection(store)
            }

            item {
                ShippingSection(
                    shipping = checkoutState.shipping,
                    onClick = { navController.navigate("shipping") }
                )
            }

            item {
                PaymentSection(
                    selected = checkoutState.payment,
                    onSelect = { checkoutViewModel.selectPayment(it) }
                )
            }
        }

        CheckoutBottomBar(
            totalProduct = totalItems,
            totalPrice = totalPrice,
            onPay = {
                if (checkoutState.payment == "QRIS") {
                    navController.navigate("qrisPayment")
                }
            },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}