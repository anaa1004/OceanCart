package com.example.oceancart.presentation.authentication.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancart.common.model.UserRole
import com.example.oceancart.ui.components.EmailTextField
import com.example.oceancart.ui.components.NameTextField
import com.example.oceancart.ui.components.PasswordTextField
import com.example.oceancart.ui.components.RegisterButton
import com.example.oceancart.ui.components.RoleSelector
import com.example.oceancart.ui.theme.DarkBlue
import com.example.oceancart.ui.theme.Inter

@Composable

fun RegisterContent(
    state: RegisterUiState,
    onRoleSelected: (UserRole) -> Unit,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onToggleConfirmPasswordVisibility: () -> Unit,
    onRegisterClick: () -> Unit,
    onNavigateToLogin: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkBlue)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
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
                    text = "DAFTAR",
                    style = TextStyle(
                        fontFamily = Inter,
                        fontSize = 24.sp,
                        color = DarkBlue
                    ),
                    modifier = Modifier
                        .padding(top = 24.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                RoleSelector(
                    selectedRole = state.selectedRole,
                    onRoleSelected = onRoleSelected
                )

                Spacer(modifier = Modifier.height(16.dp))

                NameTextField(
                    value = state.name,
                    onValueChange = onNameChange
                )

                Spacer(modifier = Modifier.height(16.dp))

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

                Spacer(modifier = Modifier.height(16.dp))

                PasswordTextField(
                    value = state.confirmPassword,
                    onValueChange = onConfirmPasswordChange,
                    visible = state.isConfirmPasswordVisible,
                    onToggleVisibility = onToggleConfirmPasswordVisibility
                )

                Spacer(modifier = Modifier.height(24.dp))

                RegisterButton(
                    isLoading = state.isLoading,
                    onClick = onRegisterClick
                )
            }
        }
    }
}