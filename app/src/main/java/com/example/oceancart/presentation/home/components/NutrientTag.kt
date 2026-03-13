package com.example.oceancart.presentation.home.components

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.ui.theme.BrightBlue
import com.example.oceancart.ui.theme.DarkBlue

@Composable

fun NutrientTag(text: String) {
    Box(
        modifier = Modifier
            .background(
                color = BrightBlue,
                RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 10.dp, vertical = 4.dp),
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 10.sp
        )
    }

}