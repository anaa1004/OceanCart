package com.example.oceancart.presentation.authentication.login

import android.graphics.fonts.FontFamily
import android.os.strictmode.UntaggedSocketViolation
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.HistoricalChange
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.R
import com.example.oceancart.ui.components.EmailTextField
import com.example.oceancart.ui.components.LoginButton
import com.example.oceancart.ui.components.OrDivider
import com.example.oceancart.ui.components.PasswordTextField
import com.example.oceancart.ui.components.SocialLoginRow
import com.example.oceancart.ui.theme.DarkBlue
import com.example.oceancart.ui.theme.Inter

@Composable

fun LoginContent(
    state: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onLoginClick: () -> Unit,
    onNavigateToRegister: () -> Unit
) {
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
                    onGoogleClick = { },
                    onFacebookClick = { },
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
                        color = Color.Gray
                    )
                    TextButton(
                        onClick = onNavigateToRegister
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