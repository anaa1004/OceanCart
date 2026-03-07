package com.example.oceancart.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckoutAdd (){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Checkout",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Produk: Salmon Segar Grade A")
        Text("Harga: Rp50.000")

        Spacer(modifier = Modifier.height(20.dp))

        Text("Alamat Pengiriman")
        Text("Kabupaten Malang")

        Spacer(modifier = Modifier.height(20.dp))

        Text("Metode Pembayaran")
        Text("Transfer Bank")

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                println("Pesanan diproses")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Bayar Sekarang")
        }
    }
}

@Composable
fun CartDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {

    AlertDialog(
        onDismissRequest = onDismiss,

        title = {
            Text("Tambah ke Keranjang")
        },

        text = {
            Text("Apakah kamu ingin menambahkan produk ke keranjang?")
        },

        confirmButton = {

            Button(
                onClick = onConfirm
            ) {
                Text("Tambah")
            }

        },

        dismissButton = {

            TextButton(
                onClick = onDismiss
            ) {
                Text("Batal")
            }

        }
    )
}