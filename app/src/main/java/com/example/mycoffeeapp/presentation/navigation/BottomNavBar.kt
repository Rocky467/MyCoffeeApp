package com.example.mycoffeeapp.presentation.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.presentation.theme.LightBrown

@Composable
fun BottomNavBar(navController: NavHostController = rememberNavController(), routeName: String) {

    val navItems = listOf(
        NavItem(BottomNavBar.Home.name, R.drawable.regular_outline_home, Routes.HomeScreen),
        NavItem(BottomNavBar.Cart.name, R.drawable.regular_outline_bag, Routes.CartScreen),
        NavItem(BottomNavBar.Favorites.name, R.drawable.regular_outline_heart, Routes.FavoriteScreen),
        NavItem(BottomNavBar.Profile.name, R.drawable.outline_account_circle_24, Routes.ProfileScreen)
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(120.dp)
    ) {

        navItems.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = "ic"
                    )
                },
                selected = routeName == item.title,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = { Text(text = item.title) },
                modifier = Modifier.size(32.dp),
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = LightBrown.copy(0.03f)
                )
            )
        }
    }
}

data class NavItem(
    val title: String,
    val icon: Int,
    val route: Routes
)

enum class BottomNavBar {
    Home,
    Cart,
    Favorites,
    Profile
}