package com.example.oceancart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.ViewAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.oceancart.presentation.authentication.login.LoginScreen
import com.example.oceancart.presentation.authentication.login.LoginViewModel
import com.example.oceancart.presentation.authentication.register.RegisterScreen
import com.example.oceancart.presentation.authentication.register.RegisterViewModel
import com.example.oceancart.presentation.home.HomeScreen

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
            LoginScreen(
                viewModel = viewModel(),
                onLoginSuccess = {
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