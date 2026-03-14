package com.example.oceancart.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.oceancart.data.model.Product
import com.example.oceancart.data.model.banners
import com.example.oceancart.data.model.navItems
import com.example.oceancart.data.model.productList
import com.example.oceancart.presentation.home.components.HomeTopBar
import com.example.oceancart.ui.components.NavBar

@Composable

fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onSearchClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onChatClick: () -> Unit,
    onProdukDetailClick: (Product) -> Unit,
    onEdukasiClick: () -> Unit,
    onKeranjangClick: () -> Unit,
    onPesananClick: () -> Unit,
    onProfilClick: () -> Unit,
    onCategoryClick: (String) -> Unit,
    onLogout: () -> Unit
) {
    var selectedIndex by remember { mutableStateOf(0) }
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        HomeContent(
            banners = uiState.banners,
            navItems = uiState.navItems,
            recommendedProducts = uiState.recommendedProducts,
            onSearchClick = onSearchClick,
            onNotificationClick = onNotificationClick,
            onChatClick = onChatClick,
            onProdukDetailClick = onProdukDetailClick,
            onEdukasiClick = onEdukasiClick,
            onKeranjangClick = onKeranjangClick,
            onPesananClick = onPesananClick,
            onProfilClick = onProfilClick,
            onCategoryClick = onCategoryClick
        )

        NavBar(
            items = navItems,
            selectedIndex = selectedIndex,
            onItemSelected = {
                index -> selectedIndex = index

                when(index) {
                    0 -> {}
                    1 -> onEdukasiClick()
                    2 -> onKeranjangClick()
                    3 -> onPesananClick()
                    4 -> onProfilClick()
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
        )
    }
}