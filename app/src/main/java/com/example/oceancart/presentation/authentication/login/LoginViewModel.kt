package com.example.oceancart.presentation.authentication.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(value: String) {
        uiState = uiState.copy(
            email = value,
            errorMessage = null
        )
    }

    fun onPasswordChange(value: String) {
        uiState = uiState.copy(
            password = value,
            errorMessage = null
        )
    }

    fun onTogglePasswordVisibility() {
        uiState = uiState.copy(
            isPasswordVisible = !uiState.isPasswordVisible
        )
    }

    fun login(
        onSuccess: () -> Unit
    ) {
        val email = uiState.email.trim()
        val password = uiState.password.trim()

        if (email.isEmpty() || password.isEmpty()) {
            uiState = uiState.copy(
                errorMessage = "Email dan Password harus diisi"
            )
            return
        }

        uiState = uiState.copy(
            isLoading = true,
            errorMessage = null
        )

        onSuccess()
    }

}