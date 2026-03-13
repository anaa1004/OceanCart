package com.example.oceancart.ui

import com.example.oceancart.ui.components.NavBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.oceancart.data.model.navItems
import com.example.oceancart.navigation.Routes
import com.example.oceancart.ui.components.profilePage.HeaderPart
import com.example.oceancart.ui.components.profilePage.LogoutButton
import com.example.oceancart.ui.components.profilePage.MenuSection
import com.example.oceancart.ui.components.profilePage.ProfileCard


@Composable
@Preview
fun ProfilePage() {

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



