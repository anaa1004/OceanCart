package com.example.oceancart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.oceancart.presentation.authentication.login.LoginContent
import com.example.oceancart.presentation.authentication.login.LoginPreview
import com.example.oceancart.presentation.authentication.register.RegisterContent
import com.example.oceancart.presentation.authentication.register.RegisterPreview
import com.example.oceancart.presentation.authentication.register.RegisterUiState
import com.example.oceancart.presentation.home.HomeContent
import com.example.oceancart.ui.ArtikelPage
import com.example.oceancart.ui.DetailPesananPage
import com.example.oceancart.ui.EdukasiPage
import com.example.oceancart.ui.HeaderBarEdukasiPreview
import com.example.oceancart.ui.PesananPage
import com.example.oceancart.ui.ProductDetailScreen
import com.example.oceancart.ui.ProductPreview
import com.example.oceancart.ui.ProfilePage
import com.example.oceancart.ui.components.productDetail.CartBottomSheetPreview
import com.facebook.FacebookSdk


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginPreview()
        }
    }
}
