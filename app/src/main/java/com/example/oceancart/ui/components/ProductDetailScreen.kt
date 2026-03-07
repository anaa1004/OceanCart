package com.example.oceancart.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.oceancart.R
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview() {
    val navController = rememberNavController()

    ProductDetailScreen(navController)
}
@Composable
fun ProductDetailScreen(navController: NavController) {
    var showDialog by remember { mutableStateOf(false) }
    var count by remember { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                    )
                }
            }
        }

        item {
            Image(
                painter = painterResource(id = R.drawable.salmon),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
            )
        }

        item {
            Text(
                text = "Salmon Segar Grade A",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Text(
                text = "Rp50.000/kg",
                fontSize = 18.sp,
                color = Color(0xFF1976D2)
            )
        }

        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                TagItem("Protein")
                TagItem("Omega 3")
                TagItem("Vitamin B")

            }
        }

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.toko_profil),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Column {
                    Text("Toko Makmur Jaya", fontWeight = FontWeight.Bold)
                    Text("Kabupaten Malang", fontSize = 12.sp)
                }
            }
        }

        item {
            Text(
                text = "Deskripsi Produk",
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Text(
                text = "Salmon Grade A adalah ikan salmon berkualitas premium..."
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                OutlinedButton(
                    onClick = { showDialog = true },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Keranjang")
                }

                Button(
                    onClick = {
                        navController.navigate("checkout")
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Beli Sekarang")
                }
            }
        }

            if (showDialog) {

                item {
                    CartDialog(

                        onDismiss = {
                            showDialog = false
                        },

                        onConfirm = {

                            println("Barang ditambahkan ke keranjang")

                            showDialog = false
                        }

                    )
                }

            }

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = {
                    if (count > 0) count--
                }) {
                    Icon(Icons.Default.Remove, null)
                }

                Text("$count")

                IconButton(onClick = {
                    count++
                }) {
                    Icon(Icons.Default.Add, null)
                }

            }
        }

        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text("Review", fontWeight = FontWeight.Bold)

                    Text("⭐⭐⭐⭐⭐")

                    Text("Salmonnya fresh banget...")

                }

            }
        }
    }
}

@Composable
fun TagItem(text: String) {
    Surface(
        color = Color(0xFFE3F2FD),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            fontSize = 12.sp
        )
    }
}