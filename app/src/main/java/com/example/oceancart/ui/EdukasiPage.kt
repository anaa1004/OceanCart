package com.example.oceancart.ui


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oceancart.R
import com.example.oceancart.ui.components.EdukasiCard
import com.example.oceancart.ui.components.NavBar
import com.example.oceancart.ui.components.PilihButton
import com.example.oceancart.ui.theme.Inter
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oceancart.data.model.navItems
import com.example.oceancart.ui.components.HeaderBar
import com.example.oceancart.navigation.Routes

@Composable
fun EdukasiPage(
    navController: NavController,
    onNavigateToArtikel: () -> Unit
) {
    var selectedIndex by remember { mutableStateOf(1) }

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                HeaderBar(
                    icon = R.drawable.icons_edukasi,
                    title = "Edukasi"
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(3f)
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    item {
                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            PilihButton(text = "Semua", selected = true, onClick = { })
                            Spacer(modifier = Modifier.width(20.dp))
                            PilihButton(text = "Disimpan", selected = false, onClick = { })
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(text = "Wajib Dibaca", fontWeight = FontWeight.SemiBold)

                        EdukasiCard(
                            onClick = {
                                Log.d("NAV", "EdukasiCard diklik, navigasi ke Artikel")
                                onNavigateToArtikel()},
                            icon = R.drawable.icons_fish,
                            title = "Cara Menerima Ikan Segar dari Nelayan",
                            description = "Panduan saat ikan tiba di restoran"
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(text = "Terbaru", fontWeight = FontWeight.SemiBold)

                        EdukasiCard(
                            onClick = {},
                            icon = R.drawable.icon_gurita,
                            title = "Cara Menjaga Kesegaran Cumi",
                            description = "Panduan cumi segar dan bergizi"
                        )

                        EdukasiCard(
                            onClick = {},
                            icon = R.drawable.icons_cube,
                            title = "Suhu Ideal Penyimpanan Ikan",
                            description = "Beda jenis ikan, beda suhu"
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