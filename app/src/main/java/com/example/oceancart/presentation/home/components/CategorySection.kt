package com.example.oceancart.presentation.home.components

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.ui.theme.DarkBlue
import com.example.oceancart.ui.theme.Inter

@Composable

fun CategorySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Kategori",
            fontFamily = Inter,
            fontSize = 18.sp,
            color = DarkBlue
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.height(90.dp)
        ) {
            item {
                CategoryItem(
                    com.example.oceancart.R.drawable.icon_ikan,
                    "Ikan"
                )
            }
            item {
                CategoryItem(
                    com.example.oceancart.R.drawable.icon_udang,
                    "Udang"
                )
            }
            item {
                CategoryItem(
                    com.example.oceancart.R.drawable.icon_gurita,
                    "Gurita"
                )
            }
            item {
                CategoryItem(
                    com.example.oceancart.R.drawable.icon_kerang,
                    "Kerang"
                )
            }
        }
    }
}