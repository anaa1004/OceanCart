package com.example.oceancart.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.R
import com.example.oceancart.ui.theme.Inter

//@Preview(showBackground = true)
//@Composable
//fun EdukasiCardPreview() {
//    EdukasiCard(
//        icon = R.drawable.icons_fish,
//        title = "Cara Menerima Ikan Segar dari Nelayan",
//        description = "Panduan saat ikan tiba di restoran"
//    )
//}




@Composable
fun EdukasiCard(
    icon: Int,
    title: String,
    description: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {

        Column {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color(0xffB9E7FF),
                                Color.White
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp),
                    tint = Color(0xFF0F5E82)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF0077B6))
                    .padding(16.dp)
            ) {

                Text(
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    fontFamily = Inter
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = description,
                    color = Color.White,
                    fontSize = 13.sp,
                    fontFamily = Inter
                )
            }
        }
    }
}

@Composable
fun PilihButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (selected) Color(0xff0077B6) else Color(0xffD9EBF4)
            )
            .border(
                1.dp,
                Color(0xff0077B6),
                RoundedCornerShape(20.dp)
            )
            .clickable { onClick() }
            .size(width = 163.dp, height = 43.dp)
    ) {

        Text(
            text = text,
            color = if (selected) Color.White else Color(0xff00476D),
            fontFamily = Inter,
            textAlign = TextAlign.Center
        )

    }
}