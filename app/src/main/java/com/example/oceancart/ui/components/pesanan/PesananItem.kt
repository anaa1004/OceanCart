package com.example.oceancart.ui.components.pesanan

import androidx.compose.ui.graphics.Color
import com.example.oceancart.ui.components.pesanan.StatusPesanan

data class PesananItem(
    val orderId: String,
    val namaProduk: String,
    val namaToko: String,
    val berat: String,
    val tanggal: String,
    val totalHarga: String,
    val status: StatusPesanan,
    val icon: Int,
    val iconBgColor: Color
)
