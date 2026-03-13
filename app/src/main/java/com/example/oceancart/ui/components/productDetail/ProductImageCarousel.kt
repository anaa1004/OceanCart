package com.example.oceancart.ui.components.productDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


// carousel di detail produk
@Composable
fun ProductImageCarousel(images: List<Int>) {
    val pagerState = rememberPagerState(pageCount = { images.size })

    Column {
        Box {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) { page ->
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


        // indikator titik di bawah
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            repeat(images.size) { index ->
                Box(
                    modifier = Modifier
                        .width(if (pagerState.currentPage == index) 24.dp else 10.dp) // panjang berbeda
                        .height(10.dp) // tinggi tetap sama
                        .background(
                            if (pagerState.currentPage == index) Color(0xffB0D5E8)
                            else Color(0xffB0D5E8),
                            RoundedCornerShape(50) // ganti CircleShape agar sesuai bentuk lonjong
                        )
                )
            }
        }
    }
}