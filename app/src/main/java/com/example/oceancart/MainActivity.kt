package com.example.oceancart

import android.content.Context
import android.net.http.HttpResponseCache.install
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
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
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.providers.builtin.OTP
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.security.MessageDigest
import java.util.UUID


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

    fun signUpWithEmail(emailValue: String, passwordValue: String): Flow<AuthResponse> = flow {
        try {
            supabase.auth.signUpWith(Email) {
                email = emailValue
                password = passwordValue
            }
        } catch (e: Exception) {
            emit(AuthResponse.Error(e.localizedMessage))
        }
    }

    fun signInWithEmail (emailValue: String, passwordValue: String): Flow<AuthResponse> = flow {
        try {
            supabase.auth.signInWith(Email){
                email = emailValue
                password = passwordValue
            }
        } catch (e: Exception) {
            emit(AuthResponse.Error(e.localizedMessage))
        }
    }

    fun verifyOtp(emailValue: String, token: String): Flow<AuthResponse> = flow {
        try {
            supabase.auth.verifyEmailOtp(
                email = emailValue,
                token = token,
                type = io.github.jan.supabase.auth.user.EmailOtpType.SIGNUP
            )
            emit(AuthResponse.Success)
        } catch (e: Exception) {
            emit(AuthResponse.Error(e.localizedMessage))
        }
    }


    fun createNonce(): String{
        val rawNonce = UUID.randomUUID().toString()
        val bytes = rawNonce.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)

        return digest.fold("") { str, it -> str + "%02x".format(it)}
    }
}

