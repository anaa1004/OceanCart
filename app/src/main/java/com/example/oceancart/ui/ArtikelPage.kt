package com.example.oceancart.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.oceancart.R
import com.example.oceancart.ui.theme.Inter
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.ktor.http.ContentType
import com.example.oceancart.ui.components.ArtikelData

@Composable
fun ArtikelPage(
    navController: NavController
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                simpanBar(selected = true)
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xffB9E7FF),
                            Color.White
                        )
                    )
                )
        ) {
            BarKembali(navController)
            
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(35.dp))
                    Image(
                        painter = painterResource(R.drawable.icons_fish),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(84.dp)
                    )
                }

                item {
                    Text(
                        text = ArtikelData.judul,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Inter,
                        fontSize = 24.sp
                    )
                    
                    Spacer(modifier = Modifier.height(12.dp))

                    HorizontalDivider(
                        color = Color(0xff737373),
                        thickness = 1.dp,
                        modifier = Modifier
                            .width(372.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = ArtikelData.paragraf1,
                        fontFamily = Inter,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = ArtikelData.langkah1Judul,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Inter,
                        fontSize = 16.sp

                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = ArtikelData.langkah1Isi,
                        fontFamily = Inter,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text (
                        text = ArtikelData.langkah2Judul,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Inter,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text (
                        text = ArtikelData.langkah2Isi,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Inter,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text (
                        text = ArtikelData.langkah3Judul,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Inter,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text (
                        text = ArtikelData.langkah3Isi,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Inter,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}


@Composable
fun BarKembali(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .background(Color(0xFF005F92))
    ) {

        Row(
            modifier = Modifier
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(R.drawable.icons_back),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .clickable {
                    navController.popBackStack()
                }
            )

            Text(
                text = "Artikel",
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center

            )
        }
    }
}

@Composable
fun simpanBar(selected: Boolean) {
    Box(
        modifier = Modifier
            .padding(vertical = 14.dp)
            .size(324.dp, 43.dp)
            .shadow(4.dp, RoundedCornerShape(20.dp))
            .background(
                if (selected) Color(0xff0077B6) else Color(0xffD9EBF4),
                RoundedCornerShape(24.dp)
            )
            .border(
                1.dp,
                Color(0xff0077B6),
                RoundedCornerShape(20.dp)
            )
            .padding(vertical = 12.dp)
            .clickable {},
        contentAlignment = Alignment.Center,
    ) {
        Text(
            "Simpan ke Profile",
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = if (selected) Color.White else Color(0xff0077B6)
        )

    }
}