package com.example.oceancart.presentation.checkout

import com.example.oceancart.data.model.Address
import com.example.oceancart.data.model.CartItem
import com.example.oceancart.data.model.ShippingOption

data class CheckoutState(
    val address: Address? = null,
    val shipping: ShippingOption? = null,
    val payment: String = "QRIS",
    val totalItems: Int = 0,
    val totalPrice: Int = 0
)