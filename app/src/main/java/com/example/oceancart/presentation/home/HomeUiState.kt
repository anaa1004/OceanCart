package com.example.oceancart.presentation.home

import com.example.oceancart.data.model.BannerItem
import com.example.oceancart.data.model.NavItem
import com.example.oceancart.data.model.Product

data class HomeUiState(
    val banners: List<BannerItem> = emptyList(),
    val navItems: List<NavItem> = emptyList(),
    val recommendedProducts: List<Product> = emptyList()
)