package com.example.oceancart.data.model

import com.example.oceancart.R

object CartData {
    val cart = listOf(
        StoreCart(
            1,
            "Toko Makmur Jaya",
            true,
            listOf(
                CartItem (
                    1,
                    "Cumi-cumi Segar",
                    "Berat: 100 kg",
                    45000,
                    R.drawable.image_cumi
                ),
                CartItem (
                    2,
                    "Cumi-cumi Segar",
                    "Berat: 100 kg",
                    45000,
                    R.drawable.image_cumi
                ),
            )
        ),
        StoreCart(
            2,
            "Toko Makmur Jaya",
            true,
            listOf(
                CartItem (
                    3,
                    "Cumi-cumi Segar",
                    "Berat: 100 kg",
                    45000,
                    R.drawable.image_cumi
                ),
                CartItem (
                    4,
                    "Cumi-cumi Segar",
                    "Berat: 100 kg",
                    45000,
                    R.drawable.image_cumi
                ),
            )
        ),
        StoreCart(
            3,
            "Toko Makmur Jaya",
            true,
            listOf(
                CartItem (
                    5,
                    "Cumi-cumi Segar",
                    "Berat: 100 kg",
                    45000,
                    R.drawable.image_cumi
                )
            )
        )
    )
}