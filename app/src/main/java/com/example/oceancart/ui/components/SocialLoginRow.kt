package com.example.oceancart.ui.components

import android.util.Log
import androidx.activity.result.ActivityResultRegistryOwner
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.oceancart.R
import com.facebook.CallbackManager
import com.facebook.login.LoginManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult

@Composable

fun SocialLoginRow(
    onGoogleClick: () -> Unit,
    onFacebookClick: () -> Unit,
    onWhatsappClick: () -> Unit
) {
    val context = LocalContext.current
    val callbackManager = remember { CallbackManager.Factory.create() }

    // Register callback Facebook
    LoginManager.getInstance().registerCallback(
        callbackManager,
        object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                val token = result.accessToken.token
                Log.d("Facebook", "Token: $token")
                // navigasi ke halaman utama
            }
            override fun onCancel() {
                Log.d("Facebook", "Login dibatalkan")
            }
            override fun onError(error: FacebookException) {
                Log.e("Facebook", "Error: ${error.message}")
            }
        }
    )

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = { onFacebookClick
//                if (context is ActivityResultRegistryOwner) {
//                    LoginManager.getInstance().logInWithReadPermissions(
//                        context,
//                        callbackManager,
//                        listOf("email", "public_profile")
//                    )
//                }
            }
        ) {
            Icon(
                painter = painterResource(R.drawable.icons_facebook),
                contentDescription = "Facebook",
                tint = Color.Unspecified
            )
        }

        IconButton(
            onClick = onGoogleClick
        ) {
            Icon(
                painter = painterResource(R.drawable.icons_google),
                contentDescription = "Google",
                tint = Color.Unspecified
            )
        }

        IconButton(
            onClick = onWhatsappClick
        ) {
            Icon(
                painter = painterResource(R.drawable.icons_whatsapp),
                contentDescription = "Whatsapp",
                tint = Color.Unspecified
            )
        }
    }
}