package com.example.oceancart.presentation.authentication.login

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.oceancart.navigation.Routes

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit,
    onNavigateToHome: () -> Unit = {}
) {

    val state = viewModel.uiState

    LoginContent(
        state = state,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onTogglePasswordVisibility = viewModel::onTogglePasswordVisibility,
        onLoginClick = {
            viewModel.login(
                onSuccess = onLoginSuccess
            )
        },
        onNavigateToRegister = onNavigateToRegister,
        onNavigateToHome = onNavigateToHome,
        onGoogleClick = {
            viewModel.loginWithGoogle(onSuccess = onNavigateToHome)
        },
        onFacebookClick = {
            viewModel.loginWithFacebook(onSuccess = onNavigateToHome)
        }
    )
}