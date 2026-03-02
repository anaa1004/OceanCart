package com.example.oceancart.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.oceancart.presentation.home.components.CategoryRow
import com.example.oceancart.presentation.home.components.HomeTopBar
import com.example.oceancart.presentation.home.components.ImageCarousel
import com.example.oceancart.ui.components.NavBar
import com.example.oceancart.presentation.home.components.RecommendationGrid

@Composable

fun HomeScreen(
    onLogout: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            HomeTopBar()

            Spacer(modifier = Modifier.height(16.dp))

            ImageCarousel()

            Spacer(modifier = Modifier.height(16.dp))

            CategoryRow()

            Spacer(modifier = Modifier.height(16.dp))

            RecommendationGrid()

        }

        NavBar(
            modifier = Modifier
                .align(BottomCenter)
        )
    }
}