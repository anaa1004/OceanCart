package com.example.oceancart.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.ui.theme.Inter

@Composable
fun HeaderBar(
    title: String,
    icon: Int? = null,          // icon di samping title, default null
    leftContent: (@Composable () -> Unit)? = null,  // konten kiri
    rightContent: (@Composable () -> Unit)? = null  // konten kanan
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp),
        shape = RectangleShape, // agar tidak ada rounded corner
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xff0077B6))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Konten kiri (tombol back, dll)
            leftContent?.invoke()

            if (leftContent != null) {
                Spacer(modifier = Modifier.width(12.dp))
            }

            // Icon opsional di samping title
            icon?.let {
                Icon(
                    painter = painterResource(it),
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(12.dp))
            }

            // Title
            Text(
                text = title,
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )

            // Konten kanan (tombol aksi, dll)
            rightContent?.invoke()
        }
    }
}