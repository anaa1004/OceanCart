package com.example.oceancart.presentation.home

import androidx.lifecycle.ViewModel
import com.example.oceancart.R
import com.example.oceancart.data.model.Product
import com.example.oceancart.data.model.banners
import com.example.oceancart.data.model.recommendedProducts
import com.example.oceancart.data.model.navItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        _uiState.value = HomeUiState(
            banners = banners,
            navItems = navItems,
            recommendedProducts = recommendedProducts
        )
    }
}