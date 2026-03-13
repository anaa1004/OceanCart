package com.example.oceancart.data.model

data class CartItem(
    val id: Int,
    val name: String,
    val weight: String,
    val price: Int,
    val image: Int,
    val quantity: Int = 1,
    val isChecked: Boolean = false
)

data class StoreCart(
    val storeId: Int,
    val storeName: String,
    val isChecked: Boolean = false,
    val items: List<CartItem>
)

data class Address(
    val id: Int,
    val name: String,
    val phone: String,
    val address: String
)

data class ShippingOption(
    val id: Int,
    val name: String,
    val estimation: String,
    val price: Int
)