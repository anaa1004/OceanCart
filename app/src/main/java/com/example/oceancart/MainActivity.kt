package com.example.oceancart

import android.content.Context
import android.net.http.HttpResponseCache.install
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.oceancart.navigation.AppNavigation
import com.example.oceancart.ui.theme.OceanCartTheme
import io.ktor.websocket.WebSocketDeflateExtension.Companion.install
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
        }
    }
}

sealed interface AuthResponse {
    data object Success: AuthResponse
    data class Error(val message: String?) : AuthResponse
}

class AuthManager (
    private val context: Context
) {

    private val supabase = createSupabaseClient (
        supabaseUrl = "https://foukqzuzgcgpbfbfhqin.supabase.co",
        supabaseKey = "sb_publishable_txhTCBT3GfaKqN8-_bnm2g_Lnf3NyYw"
    ) {
        install(Auth)
    }

    fun signUpWithEmail(emailValue: String, passwordValue: String) {

    }
}

