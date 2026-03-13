package com.example.oceancart.ui.components.pesanan

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.ui.components.pesanan.PesananItem
import com.example.oceancart.ui.components.pesanan.StatusPesanan
import com.example.oceancart.ui.theme.Inter

@Composable
fun PesananCard(
    item: PesananItem,
    onClick: () -> Unit = {}
) {
    val isDisabled = item.status == StatusPesanan.dibatalkan

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(174.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDisabled) Color(0xffCCCCCC) else Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            // Baris atas: Order ID & Status
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.orderId,
                    fontSize = 13.sp,
                    color = Color(0xFF9E9E9E),
                    fontFamily = Inter
                )
                StatusBadge(status = item.status)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Baris tengah: Icon & Info Produk
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(item.iconBgColor, RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = item.namaProduk,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        fontFamily = Inter,
                        color = if (isDisabled) Color(0xFF9E9E9E) else Color.Black
                    )
                    Text(
                        text = item.namaToko,
                        fontSize = 13.sp,
                        color = Color(0xFF9E9E9E),
                        fontFamily = Inter
                    )
                }
            }

            // Baris bawah: Berat, Tanggal & Harga (hanya jika tidak dibatalkan)

            Spacer(modifier = Modifier.height(8.dp))
            Spacer(modifier = Modifier.height(36.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${item.berat} · ${item.tanggal}",
                    fontSize = 16.sp,
                    color = Color(0xFF9E9E9E),
                    fontFamily = Inter
                )
                Text(
                    text = item.totalHarga,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0077B6),
                    fontFamily = Inter
                )
            }

        }
    }
}