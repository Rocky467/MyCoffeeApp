package com.example.mycoffeeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.mycoffeeapp.presentation.screens.cartScreen.CartScreen
import com.example.mycoffeeapp.presentation.screens.detailScreen.DetailScreen
import com.example.mycoffeeapp.presentation.screens.favoriteScreen.FavoriteScreen
import com.example.mycoffeeapp.presentation.screens.homeScreen.HomeScreen
import com.example.mycoffeeapp.presentation.screens.profileScreen.ProfileScreen
import com.example.mycoffeeapp.presentation.screens.welcomeScreen.WelcomeScreen
import kotlinx.serialization.Serializable

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WelcomeScreen) {
        composable<Routes.WelcomeScreen> { WelcomeScreen(navController) }
        composable<Routes.HomeScreen> { HomeScreen(navController) }
        composable<Routes.DetailScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Routes.DetailScreen>()
            DetailScreen(navController, args.productId)
        }
        composable<Routes.CartScreen> { CartScreen(navController) }
        composable<Routes.FavoriteScreen> { FavoriteScreen(navController) }
        composable<Routes.ProfileScreen> { ProfileScreen(navController) }
    }

}


@Serializable
sealed class Routes {

    @Serializable
    object WelcomeScreen : Routes()

    @Serializable
    object HomeScreen : Routes()

    @Serializable
    data class DetailScreen(val productId: Int) : Routes()

    @Serializable
    object CartScreen : Routes()

    @Serializable
    object FavoriteScreen : Routes()

    @Serializable
    object ProfileScreen : Routes()

}