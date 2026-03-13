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
import com.example.oceancart.data.model.chatItems
import com.example.oceancart.presentation.authentication.login.LoginScreen
import com.example.oceancart.presentation.authentication.login.LoginViewModel
import com.example.oceancart.presentation.authentication.register.RegisterScreen
import com.example.oceancart.presentation.authentication.register.RegisterViewModel
import com.example.oceancart.presentation.cart.CartScreen
import com.example.oceancart.presentation.cart.CartViewModel
import com.example.oceancart.presentation.chat.ChatListItem
import com.example.oceancart.presentation.chat.ChatListScreen
import com.example.oceancart.presentation.chat.ChatScreen
import com.example.oceancart.presentation.checkout.CheckoutScreen
import com.example.oceancart.presentation.home.HomeScreen
import com.example.oceancart.presentation.home.components.CategoryProductScreen
import com.example.oceancart.presentation.search.SearchScreen
import com.example.oceancart.ui.EdukasiPage

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
                },
                onNavigateToHome = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
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
                },
                onSearchClick = {
                    navController.navigate(Routes.SEARCH)
                },
                onNotificationClick = {
                    navController.navigate(Routes.NOTIFIKASI)
                },
                onChatClick = {
                    navController.navigate(Routes.CHAT)
                },
                onProdukDetailClick = {
                    navController.navigate(Routes.PRODUK_DETAIL)
                },
                onEdukasiClick = {
                    navController.navigate(Routes.EDUKASI)
                },
                onKeranjangClick = {
                    navController.navigate(Routes.KERANJANG) {
                        launchSingleTop = true
                        popUpTo(navController.graph.startDestinationId)
                    }
                },
                onPesananClick = {
                    navController.navigate(Routes.PESANAN)
                },
                onProfilClick = {
                    navController.navigate(Routes.PROFIL)
                },
                onCategoryClick = {
                    category -> navController.navigate("category/$category")
                }
            )
        }

        composable(Routes.CHAT) {
            ChatListScreen(
                chatItems = chatItems,
                onChatClick = {
                    chat -> navController.navigate("chat_room")
                }
            )
        }

        composable(Routes.SEARCH) {
            SearchScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Routes.CHAT_ROOM) {
            ChatScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Routes.KERANJANG) {
            CartScreen(
                onBackClick = { navController.popBackStack() },
                onCheckOutClick = {navController.navigate(Routes.CHECKOUT)}
            )
        }

        composable(Routes.CHECKOUT) {
            CheckoutScreen(
                onBackClick = { navController.popBackStack() },
                navController = navController
            )
        }

        composable("category/{category}") {
            backStackEntry ->

            val category = backStackEntry.arguments?.getString("category") ?: ""

            CategoryProductScreen(category)
        }

        composable(Routes.EDUKASI){
            EdukasiPage(
                navController = navController,
                onNavigateToArtikel = {navController.navigate(Routes.ARTIKEL)}
            )
        }



    }
}