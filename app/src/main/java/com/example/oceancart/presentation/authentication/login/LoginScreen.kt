package com.example.oceancart.presentation.authentication.login

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable

//fun LoginScreen(
//    viewModel: LoginViewModel = viewModel(),
//    onLoginSuccess: () -> Unit,
//    onNavigateToRegister: () -> Unit,
//    state: LoginUiState,
//    onEmailChange: () -> Unit,
//    onPasswordChange: () -> Unit,
//    onTogglePasswordVisibility: () -> Unit,
//    onLoginClick: () -> Unit
//) {
//
//    val state = viewModel.uiState
//
//    LoginContent(
//        state = state,
//        onEmailChange = viewModel::onEmailChange,
//        onPasswordChange = viewModel::onPasswordChange,
//        onTogglePasswordVisibility = viewModel::onTogglePasswordVisibility,
//        onLoginClick = {
//            viewModel.login(
//                onSuccess = onLoginSuccess
//            )
//        },
//        onNavigateToRegister = onNavigateToRegister
//    )
//}
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit
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
        onNavigateToRegister = onNavigateToRegister
    )
}