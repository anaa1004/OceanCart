package com.example.oceancart.presentation.authentication.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable

fun RegisterScreen(
    viewModel: RegisterViewModel = viewModel(),
    onRegisterSuccess: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    val state = viewModel.uiState

    RegisterContent(
        state = state,
        onRoleSelected = viewModel::onRoleSelected,
        onNameChange = viewModel::onNameChange,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onTogglePasswordVisibility = viewModel::onTogglePasswordVisibility,
        onConfirmPasswordChange = viewModel::onConfirmPasswordChange,
        onToggleConfirmPasswordVisibility = viewModel::onTogglePasswordVisibility,
        onRegisterClick = {
            viewModel.regist(
                onSuccess = onRegisterSuccess
            )
        },
        onNavigateToLogin = onNavigateToLogin
    )
}