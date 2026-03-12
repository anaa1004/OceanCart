package com.example.oceancart.presentation.authentication.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.oceancart.common.model.UserRole

class RegisterViewModel : ViewModel() {
    var uiState by mutableStateOf(RegisterUiState())
        private set

    fun onRoleSelected(role: UserRole) {
        uiState = uiState.copy(
            selectedRole = role
        )
    }

    fun onNameChange(value: String) {
        uiState = uiState.copy(
            name = value,
            errorMessage = null
        )
    }

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

    fun onConfirmPasswordChange(value: String) {
        uiState = uiState.copy(
            confirmPassword = value,
            errorMessage = null
        )
    }

    fun onTogglePasswordVisibility() {
        uiState = uiState.copy(
            isPasswordVisible = !uiState.isPasswordVisible
        )
    }

    fun regist(onSuccess: () -> Unit) {
        val name = uiState.name.trim()
        val email = uiState.email.trim()
        val password = uiState.password.trim()
        val confirmPassword = uiState.confirmPassword.trim()

        if (name.isEmpty() ||
            email.isEmpty() ||
            password.isEmpty() ||
            confirmPassword.isEmpty()) {
            uiState = uiState.copy(
                errorMessage = "Semua field harus diisi"
            )
            return
        }

        if (password != confirmPassword) {
            uiState = uiState.copy(
                errorMessage = "Password tidak sama"
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