package com.example.oceancart.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oceancart.R
import com.example.oceancart.data.model.Product
import com.example.oceancart.navigation.Routes
import com.example.oceancart.ui.components.productDetail.CartBottomSheet
import com.example.oceancart.ui.components.productDetail.ProductImageCarousel
import com.example.oceancart.ui.components.productDetail.ReviewCard
import com.example.oceancart.ui.components.productDetail.SuccessNotification
import com.example.oceancart.ui.components.productDetail.TagItemProduct
import com.example.oceancart.ui.theme.Inter






@Composable
fun ProductDetailScreen(
    navController: NavController,
    product: Product
) {
    var showKeranjangSheet by remember { mutableStateOf(false) }
    var showBeliSheet by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Tombol back
            item {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
                }
            }

            // Carousel gambar
            item {
                ProductImageCarousel(
                    images = listOf(
                        R.drawable.image_product1,
                        R.drawable.product_image2,
                        R.drawable.product_image3
                    )
                )
            }

            item {
                Text(
                    product.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0077B6),
                    fontFamily = Inter
                )
            }

            item {
                Text(
                    product.price,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontFamily = Inter
                )
            }

            // Tag
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    TagItemProduct("Vitamin B12")
                    TagItemProduct("Vitamin D")
                    TagItemProduct("Selenium")
                }
            }

            // Info toko
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painterResource(R.drawable.toko_profil_icons), null,
                        modifier = Modifier
                            .wrapContentSize()
                            .size(40.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(
                            "Raion Perikanan",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = Inter
                        )

                        Text(
                            "Kabupaten Malang",
                            fontSize = 13.sp,
                            fontFamily = Inter,
                            color = Color(0xffB0B0B0)
                        )

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .background(Color.Green, CircleShape))
                            Spacer(Modifier.width(4.dp))
                            Text(
                                "Online",
                                fontSize = 11.sp,
                                color = Color(0xffB0B0B0)
                            )
                        }
                    }
                    Icon(
                        painter = painterResource(R.drawable.icons_chat),
                        null,
                        tint = Color.Black
                    )
                }
            }

            // Deskripsi
            item {
                Text(
                    "Deskripsi Produk",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0077B6)
                )
            }
            item {
                Text(
                    "Salmon Grade A adalah ikan salmon berkualitas premium dengan daging berwarna oranye cerah, tekstur lembut, dan rasa yang kaya. " +
                            "Cocok diolah menjadi berbagai hidangan seperti sushi, sashimi, grill, atau masakan seafood lainnya, serta mengandung nutrisi " +
                            "penting seperti Omega-3, protein, dan vitamin D yang baik untuk kesehatan.",
                    textAlign = TextAlign.Justify,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_semibold))
                )
            }

            item {
                Box() {
                    Column() {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Star, null, tint = Color(0xFFFFC107))
                                Spacer(Modifier.width(4.dp))
                                Text(
                                    "Review",
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = Inter,
                                    fontSize = 20.sp,
                                    color = Color(0xff0077B6))
                            }
                            Text("Lihat Semua", color = Color(0xFF0077B6), fontSize = 13.sp)
                        }

                        ReviewCard(
                            namaUser = "Harry Potter",
                            fotoUser = R.drawable.user_profile,
                            rating = 4,
                            komentar = "Salmonnya fresh banget, dagingnya tebal dan lembut. Waktu dimasak rasanya gurih dan tidak amis sama sekali. " +
                                    "Cocok banget buat sushi atau dimasak simple seperti grilled salmon. Kualitasnya benar-benar terasa premium!"
                        )
                    }
                }
            }

            // Tombol Keranjang & Beli
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = { showKeranjangSheet = true },
                        border = BorderStroke(2.dp, Color(0xFF0077B6)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Keranjang")
                    }

                    Button(
                        onClick = { showBeliSheet = true },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0077B6)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Beli Sekarang")
                    }
                }
            }
        }

        // Bottom Sheet Keranjang
        if (showKeranjangSheet) {
            CartBottomSheet(
                productName = "Salmon Segar Grade A",
                productImage = R.drawable.image_product1,
                stok = 50,
                showBeliSekarang = false,
                onDismiss = { showKeranjangSheet = false },
                onBeli = {},
                onMasukKeranjang = { jumlah ->
                    println("Ditambahkan ke keranjang: $jumlah")
                    showKeranjangSheet = false
                    showSuccessDialog = true
                }
            )
        }

        // Bottom Sheet Beli Sekarang
        if (showBeliSheet) {
            CartBottomSheet(
                productName = "Salmon Segar Grade A",
                productImage = R.drawable.image_product1,
                stok = 50,
                showBeliSekarang = true,
                onDismiss = { showBeliSheet = false },
                onMasukKeranjang = {},
                onBeli = { jumlah ->
                    showBeliSheet = false
                    navController.navigate("checkout")
                }
            )
        }

        if (showSuccessDialog) {
            SuccessNotification(
                message = "Produk berhasil dimasukkan ke dalam keranjang",
                onDismiss = { showSuccessDialog = false },
                onLihatKeranjang = {
                    showSuccessDialog = false
                    navController.navigate(Routes.KERANJANG)
                }
            )
        }
    }
}




//@Preview(showBackground = true)
//@Composable
//fun ProductPreview() {
//    val navController = rememberNavController()
//
//    ProductDetailScreen(navController = navController)
//}