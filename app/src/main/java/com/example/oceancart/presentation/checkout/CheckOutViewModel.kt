package com.example.oceancart.presentation.checkout

import androidx.lifecycle.ViewModel
import com.example.oceancart.data.model.Address
import com.example.oceancart.data.model.CartItem
import com.example.oceancart.data.model.ShippingOption
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CheckoutViewModel : ViewModel() {

    private val _state = MutableStateFlow(CheckoutState())
    val state: StateFlow<CheckoutState> = _state

    fun selectPayment(payment: String) {
        _state.value = _state.value.copy(payment = payment)
    }

    fun updateTotals(totalItems: Int, totalPrice: Int) {
        _state.value = _state.value.copy(totalItems = totalItems, totalPrice = totalPrice)
    }

    fun setAddress(address: Address) {
        _state.value = _state.value.copy(address = address)
    }

    fun setShipping(shipping: ShippingOption) {
        _state.value = _state.value.copy(shipping = shipping)
    }
}