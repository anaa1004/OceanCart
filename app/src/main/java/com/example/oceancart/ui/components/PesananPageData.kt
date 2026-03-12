package com.example.oceancart.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.oceancart.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.ui.theme.Inter
import kotlin.math.round

data class PesananItem(
    val orderId: String,
    val namaProduk: String,
    val namaToko: String,
    val berat: String,
    val tanggal: String,
    val totalHarga: String,
    val status: StatusPesanan,
    val icon: Int
)

data class statusIcon(
    val bgColor: Color,
    val borderColor: Color,
    val icons: Int
)

enum class StatusPesanan {
    dikirim, belum_dibayar, selesai, dibatalkan
}

val dummyPesanan = listOf(
    PesananItem(
        orderId = "#ODR-2026-1332",
        namaProduk = "Udang Vaname",
        namaToko = "Seafood Nusantara",
        berat = "80 kg",
        tanggal = "27 Feb 2026",
        totalHarga = "Rp 3.500.000",
        status = StatusPesanan.dikirim,
        icon = R.drawable.icon_udang
    ),
    PesananItem(
        orderId = "#ODR-2026-8837",
        namaProduk = "Cumi Segar",
        namaToko = "Raion Perikanan",
        berat = "80 kg",
        tanggal = "27 Feb 2026",
        totalHarga = "Rp 2.900.000",
        status = StatusPesanan.belum_dibayar,
        icon = R.drawable.icons_cumi
    ),
    PesananItem(
        orderId = "#ODR-2026-6792",
        namaProduk = "Kakap Merah",
        namaToko = "Joko Fresh Malang",
        berat = "30 kg",
        tanggal = "26 Feb 2026",
        totalHarga = "Rp 2.250.000",
        status = StatusPesanan.selesai,
        icon = R.drawable.icons_fish
    ),
    PesananItem(
        orderId = "#ODR-2026-0927",
        namaProduk = "Lobster Mutiara",
        namaToko = "FPIK Store",
        berat = "20 kg",
        tanggal = "26 Feb 2026",
        totalHarga = "Rp 3.800.000",
        status = StatusPesanan.dibatalkan,
        icon = R.drawable.icons_lobster
    )
)


// composable function utk badge keterangan pesanan
@Composable
fun StatusBadge(status: StatusPesanan) {
    val statusData = when (status) {
        StatusPesanan.dikirim -> statusIcon(Color(0xffD9EBF4), Color(0xff0077B6), R.drawable.icons_dikirim)
        StatusPesanan.belum_dibayar -> statusIcon(Color(0xffFFD9D9), Color(0xffFF0000), R.drawable.icons_blm_dibayar)
        StatusPesanan.selesai -> statusIcon(Color(0xffE2FFD9), Color(0xff3CFF00), R.drawable.icons_selesai)
        StatusPesanan.dibatalkan -> statusIcon( Color(0xff595959), Color(0xffE6E6E6), R.drawable.icons_dibatalkan)
    }

    Box(
        modifier = Modifier
            .wrapContentWidth()
            .border(
                width = 2.dp,
                color = statusData.borderColor,
                shape = RoundedCornerShape(20.dp)
            )
            .background(statusData.bgColor, RoundedCornerShape(20.dp)) // akses via statusData
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(statusData.icons),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }
    }
}


@Composable
fun PesananCard(
    item: PesananItem,
    onClick: () -> Unit = {}
) {
    val isDisabled = item.status == StatusPesanan.dibatalkan

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
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
                    fontSize = 12.sp,
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
                        .background(Color(0xFF0077B6), RoundedCornerShape(8.dp)),
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
                        fontSize = 14.sp,
                        fontFamily = Inter,
                        color = if (isDisabled) Color(0xFF9E9E9E) else Color.Black
                    )
                    Text(
                        text = item.namaToko,
                        fontSize = 12.sp,
                        color = Color(0xFF9E9E9E),
                        fontFamily = Inter
                    )
                }
            }

            // Baris bawah: Berat, Tanggal & Harga (hanya jika tidak dibatalkan)
            if (!isDisabled) {
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(color = Color(0xFFEEEEEE))
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${item.berat} · ${item.tanggal}",
                        fontSize = 12.sp,
                        color = Color(0xFF9E9E9E),
                        fontFamily = Inter
                    )
                    Text(
                        text = item.totalHarga,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0077B6),
                        fontFamily = Inter
                    )
                }
            }
        }
    }
}