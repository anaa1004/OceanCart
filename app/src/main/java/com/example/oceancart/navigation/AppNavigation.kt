package com.example.oceancart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.oceancart.presentation.authentication.login.LoginContent
import com.example.oceancart.presentation.authentication.login.LoginScreen
import com.example.oceancart.presentation.authentication.register.RegisterScreen
import com.example.oceancart.presentation.home.HomeScreen
import com.example.oceancart.presentation.authentication.login.LoginUiState

@Composable

fun AppNavigation(
    modifier: Modifier = Modifier,
    startDestination: String = Routes.LOGIN
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(Routes.LOGIN) {
            LoginContent(
                state = LoginUiState(),
                onEmailChange = {},
                onPasswordChange = {},
                onTogglePasswordVisibility = {},
                onLoginClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) {
                            inclusive = true
                        }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate(Routes.REGISTER)
                }
            )
        }

        composable(Routes.REGISTER) {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(Routes.HOME)
                },
                onNavigateToLogin = {
                    navController.navigate(Routes.LOGIN)
                }
            )
        }

        composable(Routes.HOME) {
            HomeScreen(
                onLogout = {
                    navController.navigate(Routes.LOGIN)
                }
            )
        }

    }
}