package com.example.oceancart.presentation.authentication.login

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.ui.components.EmailTextField
import com.example.oceancart.ui.components.LoginButton
import com.example.oceancart.ui.components.OrDivider
import com.example.oceancart.ui.components.PasswordTextField
import com.example.oceancart.ui.components.SocialLoginRow
import com.example.oceancart.ui.theme.DarkBlue
import com.example.oceancart.ui.theme.Inter
import kotlinx.coroutines.launch
import com.example.oceancart.common.model.remote.AuthManager
import com.example.oceancart.common.model.remote.AuthResponse

@Composable

fun LoginContent(
    state: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onLoginClick: () -> Unit,
    onNavigateToRegister: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val authManager = remember { AuthManager(context) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkBlue)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "MASUK",
                    style = TextStyle(
                        fontFamily = Inter,
                        fontSize = 24.sp,
                        color = DarkBlue
                    ),
                    modifier = Modifier
                        .padding(top = 24.dp)
                )

                Spacer(modifier = Modifier.height(50.dp))

                EmailTextField(
                    value = state.email,
                    onValueChange = onEmailChange
                )

                Spacer(modifier = Modifier.height(16.dp))

                PasswordTextField(
                    value = state.password,
                    onValueChange = onPasswordChange,
                    visible = state.isPasswordVisible,
                    onToggleVisibility = onTogglePasswordVisibility
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .align(Alignment.End)
                ) {
                    Text(
                        text = "Lupa kata sandi?",
                        style = TextStyle(
                            fontFamily = Inter,
                            fontSize = 12.sp,
                            color = DarkBlue
                        )
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                LoginButton(
                    isLoading = state.isLoading,
                    onClick = onLoginClick
                )

                Spacer(modifier = Modifier.height(24.dp))

                OrDivider()

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Login with",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                SocialLoginRow(
                    onGoogleClick = {
                        scope.launch {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                                authManager.loginGoogleUser().collect { response ->
                                    when (response) {
                                        is AuthResponse.Success -> { }
                                        is AuthResponse.Error -> { }
                                    }
                                }
                            }
                        }
                    },
                    onFacebookClick = {
                        scope.launch {
                            authManager.loginFacebookUser().collect { response ->
                                when (response) {
                                    is AuthResponse.Success -> { /* navigasi ke home */ }
                                    is AuthResponse.Error -> { /* tampilkan error */ }
                                }
                            }
                        }
                    },
                    onWhatsappClick = { }
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Belum punya akun?",
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )
                    TextButton(
                        onClick = onNavigateToRegister,
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = "Daftar",
                            color = DarkBlue
                        )
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {

    LoginContent(
        state = LoginUiState(),
        onEmailChange = {},
        onPasswordChange = {},
        onTogglePasswordVisibility = {},
        onLoginClick = {},
        onNavigateToRegister = {}
    )
}