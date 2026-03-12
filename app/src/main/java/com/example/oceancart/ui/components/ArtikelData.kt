package com.example.oceancart.ui.components

data class Artikel(
    val id: Int,
    val title: String,
    val subtitle: String,
    val content: String,
    val icon: Int
)

object ArtikelData {

    val judul = "Cara Menerima Ikan Segar dari Nelayan"

    val paragraf1 =
        "Ikan merupakan salah satu sumber protein yang banyak dikonsumsi oleh masyarakat. " +
                "Agar kualitas ikan tetap terjaga sampai ke tangan konsumen, proses penerimaan ikan dari nelayan harus dilakukan dengan benar."

    val langkah1Judul = "1. Persiapan Tempat"

    val langkah1Isi =
        "Sebelum ikan datang dari nelayan, tempat penerimaan harus disiapkan terlebih dahulu. " +
                "Area harus bersih dan tersedia wadah seperti keranjang atau box ikan serta es batu untuk menjaga suhu ikan tetap dingin."

    val langkah2Judul = "2. Pemeriksaan Kesegaran Ikan"

    val langkah2Isi =
        "Setelah ikan tiba, lakukan pemeriksaan kesegaran ikan. Ikan segar biasanya memiliki mata yang jernih, insang berwarna merah cerah, daging kenyal, dan tidak berbau menyengat."

    val langkah3Judul = "3. Penimbangan dan Penyimpanan"

    val langkah3Isi = "Ikan yang sudah diperiksa kemudian ditimbang untuk mengetahui jumlah hasil tangkapan. Setelah itu, ikan disortir berdasarkan jenis atau ukuran lalu disimpan dengan es batu agar kesegarannya tetap terjaga.\n" +
            "Dengan proses penerimaan yang baik, kualitas ikan dapat tetap segar hingga sampai ke konsumen."
}