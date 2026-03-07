package com.example.oceancart.ui.components

import android.view.MenuItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oceancart.R


@Composable
@Preview
fun ProfilePage (){
    Scaffold(
//        bottomBar = {BottomNavigationBar()}
    ) {
        padding ->

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
    Box {
        Box(
            modifier = Modifier
                .size(150.dp)
                .offset((-40).dp, (-40).dp)
                .background(Color(0xFF2A9AD6), CircleShape)
        )
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
        elevation = CardDefaults.cardElevation(8.dp)
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
                Text("Thomas", fontWeight = FontWeight.Bold)
                Text("thomas@gmail.com")
                Text("081234567891")
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
        fontWeight = FontWeight.Bold
    )

    MenuItem(Icons.Default.Receipt, "Aktivitas Belanja")

    Text(
        "Keamanan dan Privasi",
        modifier = Modifier.padding(start = 20.dp, top = 16.dp),
        fontWeight = FontWeight.Bold
    )

    MenuItem(Icons.Default.Lock, "Kata Sandi")

    Text(
        "Pusat Bantuan",
        modifier = Modifier.padding(start = 20.dp, top = 16.dp),
        fontWeight = FontWeight.Bold
    )

    MenuItem(Icons.AutoMirrored.Filled.Chat, "Chat Admin")
}

@Composable
fun MenuItem(icon: ImageVector, title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 6.dp),
        shape = RoundedCornerShape(12.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(icon, contentDescription = null)

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = title,
                modifier = Modifier.weight(1f)
            )

            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, null)
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

//@Composable
//fun BottomNavigationBar() {
//    NavigationBarItem(...)
//}