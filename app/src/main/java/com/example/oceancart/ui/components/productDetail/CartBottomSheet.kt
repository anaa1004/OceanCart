package com.example.oceancart.ui.components.productDetail

import com.example.oceancart.ui.components.productDetail.SuccessNotification
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.R


@Composable
fun CartBottomSheet(
    productName: String,
    productImage: Int,
    stok: Int,
    onDismiss: () -> Unit,
    onBeli: (Int) -> Unit,
    onMasukKeranjang: (Int) -> Unit,
    showBeliSekarang: Boolean = true
) {
    var count by remember { mutableStateOf(0) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.4f))
            .clickable(onClick = onDismiss),
        contentAlignment = Alignment.BottomCenter
    ) {
        Card(
            modifier = Modifier
                .height(248.dp)
                .fillMaxWidth()
                .clickable(enabled = false) {},
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                // Tombol close
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = null)
                    }
                }

                // Info produk
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(productImage),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            productName,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color(0xFF0077B6)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("Stok: $stok", fontSize = 13.sp, color = Color.Gray)

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            // Counter kiri
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(18.dp)
                                        .background(Color(0xFF0077B6), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        Icons.Default.Remove,
                                        null,
                                        tint = Color.White,
                                        modifier = Modifier
                                            .size(14.dp)
                                            .clickable { if (count > 0) count-- })
                                }

                                Text(
                                    "$count",
                                    modifier = Modifier
                                        .padding(horizontal = 16.dp)
                                        .background(Color.LightGray),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                )

                                Box(
                                    modifier = Modifier
                                        .size(18.dp)
                                        .background(Color(0xFF0077B6), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        Icons.Default.Add,
                                        null,
                                        tint = Color.White,
                                        modifier = Modifier
                                            .size(14.dp)
                                            .clickable { if (count < stok) count++ })
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Tombol keranjang/beli
                Button(
                    onClick = {
                        if (showBeliSekarang) onBeli(count)
                        else onMasukKeranjang(count)
                        showSuccessDialog = true
                    },
                    modifier = Modifier.align(Alignment.End),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0077B6)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(if (showBeliSekarang) "Beli Sekarang" else "Masukkan Keranjang")
                }
            }
        }
        if (showSuccessDialog) {
            SuccessNotification(
                message = "Produk berhasil dimasukkan ke dalam keranjang",
                onDismiss = { showSuccessDialog = false },
                onLihatKeranjang = {
                    showSuccessDialog = false
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CartBottomSheetPreview() {
    CartBottomSheet(
        productName = "Salmon Grade A",
        productImage = R.drawable.image_product1, // ganti dengan drawable yang ada di projectmu
        stok = 25,
        onDismiss = {},
        onBeli = {},
        onMasukKeranjang = {},
        showBeliSekarang = true
    )
}
