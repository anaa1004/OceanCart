package com.example.oceancart.ui.components

import android.graphics.drawable.Icon
import android.view.MenuItem
import com.example.oceancart.ui.components.NavBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.R
import com.example.oceancart.ui.theme.Inter


@Composable
@Preview
fun ProfilePage() {

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
//            NavBar(
//                selectedIndex = selectedIndex,
//                onItemSelected = { index ->
//                    selectedIndex = index
//                }
//            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xffF5F5F5))
        ) {

            HeaderPart()

            ProfileCard()

            MenuSection()

            LogoutButton()


        }
    }
}



@Composable
fun HeaderPart (){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
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

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .offset(y = (-40).dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(R.drawable.profile_img),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text("Thomas", fontWeight = FontWeight.Bold, fontFamily = Inter)
                Text("thomas@gmail.com", fontFamily = Inter, color = Color.Gray)
                Text("081234567891", fontFamily = Inter, color = Color.Gray)
            }

            Icon(Icons.Default.Edit, contentDescription = "Edit")
        }
    }
}

@Composable
fun MenuSection(){
    Text(
        "Aktivitas & Transaksi",
        modifier = Modifier.padding(start = 20.dp, top = 16.dp),
        fontWeight = FontWeight.Bold,
        fontFamily = Inter,
        fontSize = 20.sp,
        color = Color(0xff0077B6)
    )

    MenuItem(R.drawable.aktivitas_belanja, "Aktivitas Belanja")

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        "Keamanan dan Privasi",
        modifier = Modifier.padding(start = 20.dp, top = 16.dp),
        fontWeight = FontWeight.Bold,
        fontFamily = Inter,
        fontSize = 20.sp,
        color = Color(0xff0077B6)
    )

    MenuItem(R.drawable.lock_sandi, "Kata Sandi")

    Text(
        "Pusat Bantuan",
        modifier = Modifier.padding(start = 20.dp, top = 16.dp),
        fontWeight = FontWeight.Bold,
        fontFamily = Inter,
        fontSize = 20.sp,
        color = Color(0xff0077B6)
    )

    MenuItem(R.drawable.icons_admin, "Chat Admin")
}

@Composable
fun MenuItem(icon: Int, title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = Color.Black
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = title,
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.onSurface,
                fontFamily = Inter
            )

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun LogoutButton() {

    Row(
        modifier = Modifier
            .padding(20.dp)
    ) {

        Icon(
            Icons.AutoMirrored.Filled.Logout,
            contentDescription = null,
            tint = Color.Red
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            "Keluar",
            color = Color.Red
        )
    }
}