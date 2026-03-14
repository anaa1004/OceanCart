package com.example.oceancart.ui.components.profilePage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.R
import com.example.oceancart.ui.theme.Inter

@Composable
fun MenuItem(
    icon: Int,
    title: String,
    showCard: Boolean = true
) {
    val content: @Composable () -> Unit = {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = title,
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.onSurface,
                fontFamily = Inter
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }

    if (showCard) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 6.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            content()
        }
    } else {
        content()
    }
}


@Composable
fun MenuSection() {
    Box() {
        Column {
            Text(
                "Aktivitas & Transaksi",
                modifier = Modifier.padding(start = 20.dp, top = 16.dp),
                fontWeight = FontWeight.Bold,
                fontFamily = Inter,
                fontSize = 20.sp,
                color = Color(0xff0077B6)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column {
                    MenuItem(R.drawable.aktivitas_belanja, "Aktivitas Belanja", showCard = false)

                    // Divider pemisah antar item
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        thickness = 1.dp,
                        color = Color(0xFFE0E0E0)
                    )

                    MenuItem(R.drawable.icons_bookmark, "Artikel Tersimpan", showCard = false)
                }
            }
        }
    }


    Spacer(modifier = Modifier.height(20.dp))

    Text(
        "Keamanan dan Privasi",
        modifier = Modifier.padding(start = 20.dp, top = 16.dp),
        fontWeight = FontWeight.Bold,
        fontFamily = Inter,
        fontSize = 20.sp,
        color = Color(0xff0077B6)
    )

    MenuItem(R.drawable.lock_sandi, "Kata Sandi")

    Text(
        "Pusat Bantuan",
        modifier = Modifier.padding(start = 20.dp, top = 16.dp),
        fontWeight = FontWeight.Bold,
        fontFamily = Inter,
        fontSize = 20.sp,
        color = Color(0xff0077B6)
    )

    MenuItem(R.drawable.icons_admin, "Chat Admin")
}