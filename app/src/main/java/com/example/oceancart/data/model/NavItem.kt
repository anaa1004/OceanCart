package com.example.oceancart.data.model

import com.example.oceancart.R

data class NavItem(
    val icon: Int,
    val label: String,
    val route: String
)

val navItems = listOf(
    NavItem(R.drawable.icons_home, "Beranda", "home"),
    NavItem(R.drawable.icons_edukasi, "Edukasi", "edukasi"),
    NavItem(R.drawable.icons_cart, "Keranjang", "keranjang"),
    NavItem(R.drawable.icons_order, "Pesanan", "pesanan"),
    NavItem(R.drawable.icons_group, "Profil", "profil")
)