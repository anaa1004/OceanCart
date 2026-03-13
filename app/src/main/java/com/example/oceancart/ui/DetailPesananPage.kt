package com.example.oceancart.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oceancart.ui.components.HeaderBar
import com.example.oceancart.ui.components.NavBar
import com.example.oceancart.ui.components.pesanan.DummyPesanan.dummyPesanan
import com.example.oceancart.ui.components.pesanan.PesananCard

@Composable
@Preview
fun DetailPesananPage(
){
    var selectedIndex by remember { mutableStateOf(0) }
    Scaffold(
        bottomBar = {
            NavBar(
                selectedIndex = selectedIndex,
                onItemSelected = { index ->
                    selectedIndex = index
                }
            )
        }
    ) {
            innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            HeaderBar(
                title = "Pesanan Saya",
            )

            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(
            ) {
                items (dummyPesanan) { pesanan ->
                    PesananCard(
                        item = pesanan,
                        onClick = { /* navigasi ke Detail Pesanan */ }
                    )
                }
            }
        }
    }
}