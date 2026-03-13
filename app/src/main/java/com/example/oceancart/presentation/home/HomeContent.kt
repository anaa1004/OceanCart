package com.example.oceancart.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.oceancart.data.model.BannerItem
import com.example.oceancart.data.model.NavItem
import com.example.oceancart.data.model.Product
import com.example.oceancart.data.model.recommendedProducts
import com.example.oceancart.presentation.home.components.BannerCarousel
import com.example.oceancart.presentation.home.components.BestSellerSection
import com.example.oceancart.presentation.home.components.CategorySection
import com.example.oceancart.presentation.home.components.HomeSearchBar
import com.example.oceancart.presentation.home.components.HomeTopBar
import com.example.oceancart.presentation.home.components.RecommendationSection


@Composable

fun HomeContent(
    banners: List<BannerItem>,
    navItems: List<NavItem>,
    recommendedProducts: List<Product>,
    onSearchClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onChatClick: () -> Unit,
    onProdukDetailClick: () -> Unit,
    onEdukasiClick: () -> Unit,
    onKeranjangClick: () -> Unit,
    onPesananClick: () -> Unit,
    onProfilClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 80.dp)
    ) {

        HomeTopBar(
            onChatClick = onChatClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        HomeSearchBar(
            onSearchClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        BannerCarousel()

        Spacer(modifier = Modifier.height(16.dp))

        CategorySection()

        Spacer(modifier = Modifier.height(16.dp))

        RecommendationSection(recommendedProducts)

        Spacer(modifier = Modifier.height(16.dp))

        BestSellerSection(recommendedProducts)

    }

}
