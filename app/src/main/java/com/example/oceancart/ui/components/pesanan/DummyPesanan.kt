package com.example.oceancart.ui.components.pesanan

import androidx.compose.ui.graphics.Color
import com.example.oceancart.R

object DummyPesanan {
    val dummyPesanan = listOf(
        PesananItem(
            orderId = "#ODR-2026-1332",
            namaProduk = "Udang Vaname",
            namaToko = "Seafood Nusantara",
            berat = "80 kg",
            tanggal = "27 Feb 2026",
            totalHarga = "Rp 3.500.000",
            status = StatusPesanan.dikirim,
            icon = R.drawable.icon_udang,
            iconBgColor = Color(0xffFD8300)
        ),
        PesananItem(
            orderId = "#ODR-2026-8837",
            namaProduk = "Cumi Segar",
            namaToko = "Raion Perikanan",
            berat = "80 kg",
            tanggal = "27 Feb 2026",
            totalHarga = "Rp 2.900.000",
            status = StatusPesanan.belum_dibayar,
            icon = R.drawable.icons_cumi,
            iconBgColor = Color(0xff6C757D)
        ),
        PesananItem(
            orderId = "#ODR-2026-6792",
            namaProduk = "Kakap Merah",
            namaToko = "Joko Fresh Malang",
            berat = "30 kg",
            tanggal = "26 Feb 2026",
            totalHarga = "Rp 2.250.000",
            status = StatusPesanan.selesai,
            icon = R.drawable.icons_fish,
            iconBgColor = Color(0xff0098E9)
        ),
        PesananItem(
            orderId = "#ODR-2026-0927",
            namaProduk = "Lobster Mutiara",
            namaToko = "FPIK Store",
            berat = "20 kg",
            tanggal = "26 Feb 2026",
            totalHarga = "Rp 3.800.000",
            status = StatusPesanan.dibatalkan,
            icon = R.drawable.icons_lobster,
            iconBgColor = Color(0xff7A7A7A)
        )
    )
}