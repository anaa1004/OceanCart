package com.example.oceancart.common.model.remote

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.OtpType
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.Google
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.providers.builtin.IDToken
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.security.MessageDigest
import java.util.UUID
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.auth.providers.Facebook

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
        install(Postgrest)
    }

    fun loginFacebookUser(): Flow<AuthResponse> = flow {
        try {
            Log.d("FacebookLogin", "Memulai login Facebook...")
            supabase.auth.signInWith(Facebook)
            Log.d("FacebookLogin", "Login Facebook berhasil")
            emit(AuthResponse.Success)
        } catch (e: Exception) {
            Log.e("FacebookLogin", "Login Facebook gagal: ${e.localizedMessage}")
            Log.e("FacebookLogin", "Cause: ${e.cause}")
            emit(AuthResponse.Error(e.localizedMessage))
        }
    }

    fun signUpWithEmail(
        emailValue: String,
        passwordValue: String,
        name: String,
        phoneNomor: String,
        roles: String
        ): Flow<AuthResponse> = flow {
        try {
            supabase.auth.signUpWith(Email) {
                email = emailValue
                password = passwordValue
            }

            val userId = supabase.auth.currentUserOrNull()

            if (userId != null) {

                supabase.postgrest["clients"].insert(
                    mapOf(
                        "id" to userId.toString(),
                        "full_name" to name,
                        "email" to emailValue,
                        "roles" to roles,
                        "phone_number" to phoneNomor,
                        "password" to passwordValue
                    )
                )

            }

            emit(AuthResponse.Success)

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

            emit(AuthResponse.Success)

        } catch (e: Exception) {
            emit(AuthResponse.Error(e.localizedMessage))
        }
    }

    fun verifyOtp(emailValue: String, token: String): Flow<AuthResponse> = flow {
        try {
            supabase.auth.verifyEmailOtp(
                email = emailValue,
                token = token,
                type = OtpType.Email.SIGNUP
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

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)

    fun loginGoogleUser(): Flow<AuthResponse> = flow {
        val hashedNonce = createNonce()

        val googleIdOption = GetGoogleIdOption.Builder()
            .setServerClientId("322963570763-3bcdf0brt9jpvdtunrl2vm8dae67nv01.apps.googleusercontent.com")
            .setNonce(hashedNonce)
            .setAutoSelectEnabled(false)
            .setFilterByAuthorizedAccounts(false)
            .build()

        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        val credentialManager = CredentialManager.create(context)

        try {
            val result = credentialManager.getCredential(
                context = context,
                request = request
            )

            val googleIdTokenCredential = GoogleIdTokenCredential
                .createFrom(result.credential.data)

            val googleIdToken = googleIdTokenCredential.idToken

            supabase.auth.signInWith(IDToken) {
                idToken = googleIdToken;
                provider = Google
            }

            emit(AuthResponse.Success)

        } catch (e: Exception) {
            emit (AuthResponse.Error(e.localizedMessage))
        }
    }
}