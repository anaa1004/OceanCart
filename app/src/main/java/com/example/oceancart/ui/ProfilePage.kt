package com.example.oceancart.ui

import com.example.oceancart.ui.components.NavBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.oceancart.ui.components.profilePage.HeaderPart
import com.example.oceancart.ui.components.profilePage.LogoutButton
import com.example.oceancart.ui.components.profilePage.MenuSection
import com.example.oceancart.ui.components.profilePage.ProfileCard


@Composable
@Preview
fun ProfilePage() {

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavBar(
                selectedIndex = selectedIndex,
                onItemSelected = { index ->
                    selectedIndex = index
                }
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



