package com.example.oceancart.ui.components.profilePage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.ui.theme.Inter

@Composable
fun HeaderPart (){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(104.dp)
            .background(
                color = Color(0xFF0077B6),
                shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
            )
    ) {

        // Bubble kiri atas
        Box(
            modifier = Modifier
                .size(220.dp)
                .offset(x = (-80).dp, y = (-60).dp)
                .background(
                    color = Color(0xFF005989),
                    shape = CircleShape
                )
        )

        // Bubble kanan
        Box(
            modifier = Modifier
                .size(156.dp)
                .offset(x = 274.dp, y = (24).dp)
                .background(
                    color = Color(0xFF005989),
                    shape = CircleShape
                )
        )

        // Bubble bawah transparan
        Box(
            modifier = Modifier
                .size(125.dp)
                .offset(x = 250.dp, y = 120.dp)
                .background(
                    color = Color(0xffB0D5E8),
                    shape = CircleShape
                )
        )

        // Text header
        Column(
            modifier = Modifier
                .padding(24.dp)
        ) {

            Text(
                text = "Profil",
                color = Color.White,
                fontSize = 26.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold
            )

        }
    }
}