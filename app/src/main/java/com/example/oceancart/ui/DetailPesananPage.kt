package com.example.oceancart.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
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
import com.example.oceancart.data.model.navItems
import com.example.oceancart.navigation.Routes
import com.example.oceancart.ui.components.HeaderBar
import com.example.oceancart.ui.components.NavBar
import com.example.oceancart.ui.components.pesanan.DummyPesanan.dummyPesanan
import com.example.oceancart.ui.components.pesanan.PesananCard
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
@Preview
fun DetailPesananPage(
){
    var selectedIndex by remember { mutableStateOf(0) }
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavBar(
                items = navItems,
                selectedIndex = selectedIndex,
                onItemSelected = {
                        index -> selectedIndex = index

                    when(index) {
                        0 -> navController.navigate(Routes.HOME)
                        1 -> {}
                        2 -> navController.navigate(Routes.KERANJANG)
                        3 -> navController.navigate(Routes.PESANAN)
                        4 -> navController.navigate(Routes.PROFIL)
                    }
                },
                modifier = Modifier
                    .navigationBarsPadding()
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