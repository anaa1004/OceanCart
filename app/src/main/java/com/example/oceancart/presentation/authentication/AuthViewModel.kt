package com.example.oceancart.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.oceancart.AuthManager
import com.example.oceancart.AuthResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    object OtpSent : AuthState()
    object OtpVerified : AuthState()
    object LoggedIn : AuthState()
    data class Error(val message: String) : AuthState()
}

class AuthViewModel(private val authManager: AuthManager) : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState

    fun register(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            _authState.value = AuthState.Error("Email dan password tidak boleh kosong")
            return
        }
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            authManager.signUpWithEmail(email, password).collectLatest { response ->
                when (response) {
                    is AuthResponse.Success -> _authState.value = AuthState.OtpSent
                    is AuthResponse.Error -> _authState.value = AuthState.Error(
                        response.message ?: "Gagal mendaftar"
                    )
                }
            }
        }
    }

    fun verifyOtp(email: String, otp: String) {
        if (otp.isBlank()) {
            _authState.value = AuthState.Error("Masukkan kode OTP")
            return
        }
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            authManager.verifyOtp(email, otp).collectLatest { response ->
                when (response) {
                    is AuthResponse.Success -> _authState.value = AuthState.OtpVerified
                    is AuthResponse.Error -> _authState.value = AuthState.Error(
                        response.message ?: "OTP tidak valid"
                    )
                }
            }
        }
    }

    fun login(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            _authState.value = AuthState.Error("Email dan password tidak boleh kosong")
            return
        }
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            authManager.signInWithEmail(email, password).collectLatest { response ->
                when (response) {
                    is AuthResponse.Success -> _authState.value = AuthState.LoggedIn
                    is AuthResponse.Error -> _authState.value = AuthState.Error(
                        response.message ?: "Email atau password salah"
                    )
                }
            }
        }
    }

    fun resetState() {
        _authState.value = AuthState.Idle
    }

    class Factory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(AuthManager(context)) as T
        }
    }
}