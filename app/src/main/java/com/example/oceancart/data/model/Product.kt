package com.example.oceancart.data.model

import com.example.oceancart.R

data class Product(
    val name: String,
    val price: String,
    val imageRes: Int,
    val nutrientTags: List<String>
)

val recommendedProducts = listOf(
    Product(
        "Salmon Segar Grade A",
        "Rp 50.000",
        R.drawable.image_product1,
        listOf("Protein", "Omega 3")
    ),

    Product(
        "Salmon Segar Grade A",
        "Rp 50.000",
        R.drawable.image_product2,
        listOf("Protein", "Omega 3")
    ),

    Product(
        "Salmon Segar Grade A",
        "Rp 50.000",
        R.drawable.image_product3,
        listOf("Protein", "Omega 3")
    )
)