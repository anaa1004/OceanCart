package com.example.oceancart.common.model.remote

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultRegistryOwner
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.oceancart.R
import com.facebook.CallbackManager
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.facebook.FacebookCallback

@Composable
fun FacebookLoginButton(
    onSuccess: (String) -> Unit, // token
    onError: (String) -> Unit
) {
    val context = LocalContext.current
    val callbackManager = remember { CallbackManager.Factory.create() }

    // Register callback
    LoginManager.getInstance().registerCallback(
        callbackManager,
        object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                onSuccess(result.accessToken.token)
            }

            override fun onCancel() {
                onError("Login dibatalkan")
            }

            override fun onError(error: FacebookException) {
                onError(error.message ?: "Terjadi kesalahan")
            }
        }
    )

    // Tangkap activity result
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        callbackManager.onActivityResult(
            result.resultCode,
            result.resultCode,
            result.data
        )
    }

    Button(
        onClick = {
            LoginManager.getInstance().logInWithReadPermissions(
                context as ActivityResultRegistryOwner,
                callbackManager,
                listOf("email", "public_profile")
            )
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1877F2) // warna biru Facebook
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(R.drawable.icons_facebook),
            contentDescription = null,
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Login dengan Facebook", color = Color.White)
    }
}