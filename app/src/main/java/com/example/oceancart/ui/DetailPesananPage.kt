package com.example.oceancart.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun DetailPesananPage(
    navController: NavController
) {
    var selectedIndex by remember { mutableStateOf(3) }


    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ) {

            Column(modifier = Modifier.fillMaxSize()) {

                HeaderBar(title = "Pesanan Saya")

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentPadding = PaddingValues(bottom = 100.dp)
                ) {
                    items(dummyPesanan) { pesanan ->
                        PesananCard(
                            item = pesanan,
                            onClick = { }
                        )
                    }
                }
            }


            NavBar(
                items = navItems,
                selectedIndex = selectedIndex,
                onItemSelected = { index ->
                    selectedIndex = index
                    val route = when (index) {
                        0 -> Routes.HOME
                        1 -> Routes.EDUKASI
                        2 -> Routes.KERANJANG
                        3 -> Routes.PESANAN
                        4 -> Routes.PROFIL
                        else -> return@NavBar
                    }
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .navigationBarsPadding()
            )
        }
    }
}