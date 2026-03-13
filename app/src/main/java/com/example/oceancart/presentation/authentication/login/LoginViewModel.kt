package com.example.oceancart.presentation.authentication.login

import android.app.Application
import android.os.Build
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oceancart.common.model.remote.AuthManager
import com.example.oceancart.common.model.remote.AuthResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val application: Application
) : AndroidViewModel(application) { // ganti ViewModel dengan AndroidViewModel

    private val authManager = AuthManager(application)

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(value: String) {
        uiState = uiState.copy(email = value, errorMessage = null)
    }

    fun onPasswordChange(value: String) {
        uiState = uiState.copy(password = value, errorMessage = null)
    }

    fun onTogglePasswordVisibility() {
        uiState = uiState.copy(isPasswordVisible = !uiState.isPasswordVisible)
    }

    fun login(onSuccess: () -> Unit) {
        val email = uiState.email.trim()
        val password = uiState.password.trim()

        if (email.isEmpty() || password.isEmpty()) {
            uiState = uiState.copy(errorMessage = "Email dan Password harus diisi")
            return
        }

        viewModelScope.launch {
            authManager.signInWithEmail(email, password).collect { response ->
                when (response) {
                    is AuthResponse.Success -> onSuccess()
                    is AuthResponse.Error -> {
                        uiState = uiState.copy(errorMessage = response.message)
                    }
                }
            }
        }
    }


    fun loginWithGoogle(onSuccess: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            viewModelScope.launch {
                authManager.loginGoogleUser().collect { response ->
                    when (response) {
                        is AuthResponse.Success -> onSuccess()
                        is AuthResponse.Error -> {
                            uiState = uiState.copy(errorMessage = response.message)
                        }
                    }
                }
            }
        }
    }


    fun loginWithFacebook(onSuccess: () -> Unit) {
        viewModelScope.launch {
            authManager.loginFacebookUser().collect { response ->
                when (response) {
                    is AuthResponse.Success -> onSuccess()
                    is AuthResponse.Error -> {
                        uiState = uiState.copy(errorMessage = response.message)
                    }
                }
            }
        }
    }
}