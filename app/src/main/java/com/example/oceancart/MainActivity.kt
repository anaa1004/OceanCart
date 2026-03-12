package com.example.oceancart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.oceancart.presentation.authentication.login.LoginPreview
import com.example.oceancart.presentation.authentication.register.RegisterContent
import com.example.oceancart.presentation.authentication.register.RegisterPreview
import com.example.oceancart.presentation.authentication.register.RegisterUiState
import com.example.oceancart.presentation.home.HomeContent
import com.example.oceancart.ui.ArtikelPage
import com.example.oceancart.ui.EdukasiPage



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginPreview()
        }
    }
}

//@Composable
//fun AppNavigation() {
//    val navController = rememberNavController()
//
//    NavHost(
//        navController = navController,
//        startDestination = "edukasi"
//    ) {
//
//        composable("edukasi") {
//            EdukasiPage(navController)
//        }
//
//        composable("detailArtikel") {
//            ArtikelPage()
//        }
//    }
//}
