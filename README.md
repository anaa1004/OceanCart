
OceanCart 🛒
OceanCart adalah aplikasi marketplace Android yang dibuat menggunakan Kotlin dan Jetpack Compose. 
Dalam aplikasi ini pengguna dapat melihat katalog produk sesuai kategori, menambahkan produk ke dalam keranjang, dan membaca artikel edukasi.

🚀 Fitur Utama
- Authentication untuk memverifikasi identitas pengguna
- Katalog produk untuk menampilkan dan mengelola daftar produk secara terstruktur.
- Page Edukasi sebagai pusat informasi dan panduan (knowledge base) bagi pengguna mengenai cara perawatan ikan, tips karantina, hingga penanganan pertama saat ikan sampai.

🧱 Arsitektur
Aplikasi ini menggunakan arsitektur MVVM (Model-View-ViewModel).
Struktur utama project:
data
├─ model
│   ├─ BannerItem
│   ├─ Cart
│   ├─ CartData
│   └─ ChatItem
│   └─ ChatMessage
│   └─ NavItem
│   └─ Product

navigation
├─ AppNavigation
└─ Routes

presentation
├─ authentication
├─ cart
├─ chat
├─ checkout
├─ home
└─ search

Komponen utama
Model → menyimpan struktur data aplikasi
ViewModel → mengelola state aplikasi
Composable UI → tampilan menggunakan Jetpack Compose
Navigation → perpindahan antar screen

🛠 Teknologi yang Digunakan
Kotlin
Jetpack Compose
MVVM Architecture
StateFlow
Navigation Compose
Material 3

📱 Alur Aplikasi
1. User masuk ke dalam aplikasi
2. User melihat katalog produk sesuai kategori
3. User menekan tombol "Masukkan keranjang"
4. Produk akan tertera di keranjang
5. Jika User menekan tombol beli sekarang, maka akan masuk ke page checkout

▶ Cara Menjalankan Project
1. Clone repository
2. git clone 
3. Buka project di Android Studio
4. Jalankan emulator atau hubungkan perangkat Android
5. Klik Run App
