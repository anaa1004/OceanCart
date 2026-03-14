package com.example.oceancart.ui

import com.example.oceancart.ui.components.NavBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.oceancart.data.model.navItems
import com.example.oceancart.navigation.Routes
import com.example.oceancart.ui.components.profilePage.HeaderPart
import com.example.oceancart.ui.components.profilePage.LogoutButton
import com.example.oceancart.ui.components.profilePage.MenuSection
import com.example.oceancart.ui.components.profilePage.ProfileCard


@Composable
fun ProfilePage(
    navController: NavController
) {

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentPadding = innerPadding
            ) {

                item { HeaderPart() }

                item { ProfileCard() }

                item { MenuSection() }

                item { LogoutButton() }
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
                        popUpTo(navController.graph.startDestinationId){
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



