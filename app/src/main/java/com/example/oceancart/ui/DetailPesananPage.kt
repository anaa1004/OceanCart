package com.example.oceancart.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.R
import com.example.oceancart.ui.components.HeaderBar
import com.example.oceancart.ui.components.PesananCard
import com.example.oceancart.ui.components.dummyPesanan

@Composable
@Preview
fun DetailPesananPage(){
    Scaffold() {
            innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            HeaderBar(
                title = "Detail Pesanan",
                leftContent ={
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Kembali",
                        tint = Color.White
                    )
                },
                rightContent = {
                    Box(
                        modifier = Modifier
                            .background(Color(0xffD9EBF4), RoundedCornerShape(20.dp))
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.icons_dikirim),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                }
            )

            LazyColumn() {
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