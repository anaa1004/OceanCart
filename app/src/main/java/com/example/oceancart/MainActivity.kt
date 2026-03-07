package com.example.oceancart

//import android.content.Context
//import androidx.credentials.CredentialManager
//import android.credentials.CredentialOption
//import androidx.credentials.GetCredentialRequest
//import android.net.http.HttpResponseCache.install
//import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.isSystemInDarkTheme
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.oceancart.navigation.AppNavigation
//import com.example.oceancart.ui.theme.OceanCartTheme
//import com.example.oceancart.viewmodel.AuthState
//import com.google.android.libraries.identity.googleid.GetGoogleIdOption
//import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
//import io.ktor.websocket.WebSocketDeflateExtension.Companion.install
//import io.github.jan.supabase.createSupabaseClient
//import io.github.jan.supabase.auth.Auth
//import io.github.jan.supabase.auth.auth
//import io.github.jan.supabase.auth.providers.Google
//import io.github.jan.supabase.auth.providers.builtin.Email
//import io.github.jan.supabase.auth.providers.builtin.IDToken
//import io.github.jan.supabase.auth.providers.builtin.OTP
//import io.github.jan.supabase.auth.OtpType
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import java.security.MessageDigest
//import java.util.UUID
import androidx.navigation.compose.*
import com.example.oceancart.ui.components.CheckoutAdd
import com.example.oceancart.ui.components.ProductDetailScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "product"
            ) {

                composable("product") {
                    ProductDetailScreen(navController)
                }

                composable("checkout") {
                    CheckoutAdd()
                }

            }
        }
    }
}

