package com.example.oceancart.presentation.authentication

import androidx.compose.material.icons.Icons
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.oceancart.viewmodel.AuthState
import com.example.oceancart.viewmodel.AuthViewModel

@Composable
fun OtpScreen(
    email: String,
    onOtpVerified: () -> Unit,   // navigasi ke LoginScreen
    onNavigateBack: () -> Unit,
    authViewModel: AuthViewModel = viewModel()
) {
    var otpCode by remember { mutableStateOf("") }
    val authState by authViewModel.authState.collectAsState()

    // Navigasi ke Login setelah OTP berhasil diverifikasi
    LaunchedEffect(authState) {
        if (authState is AuthState.OtpVerified) {
            onOtpVerified()
            authViewModel.resetState()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA))
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.TopEnd)
                .offset(x = 60.dp, y = (-40).dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(Color(0xFF4FC3F7), Color(0xFF0288D1))
                    ),
                    shape = RoundedCornerShape(50)
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp)
        ) {
            Spacer(modifier = Modifier.height(56.dp))

            IconButton(onClick = onNavigateBack) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Kembali",
                    tint = Color(0xFF1A1A2E)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Verifikasi\nEmail",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A2E),
                lineHeight = 40.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Kode OTP telah dikirim ke", fontSize = 14.sp, color = Color(0xFF888888))
            Text(text = email, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF0288D1))

            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = otpCode,
                onValueChange = { if (it.length <= 6) otpCode = it },
                label = { Text("Kode OTP") },
                placeholder = { Text("______", letterSpacing = 6.sp) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center,
                    letterSpacing = 8.sp,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                ),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF0288D1),
                    unfocusedBorderColor = Color(0xFFDDDDDD),
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            if (authState is AuthState.Error) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = (authState as AuthState.Error).message,
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            Button(
                onClick = { authViewModel.verifyOtp(email, otpCode) },
                enabled = otpCode.length == 6 && authState !is AuthState.Loading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0288D1),
                    disabledContainerColor = Color(0xFFB0BEC5)
                )
            ) {
                if (authState is AuthState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(22.dp),
                        color = Color.White,
                        strokeWidth = 2.dp
                    )
                } else {
                    Text("Verifikasi", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Tidak menerima kode?", color = Color(0xFF888888), fontSize = 14.sp)
                TextButton(onClick = { authViewModel.register(email, "") }) {
                    Text("Kirim Ulang", color = Color(0xFF0288D1), fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                }
            }
        }
    }
}
