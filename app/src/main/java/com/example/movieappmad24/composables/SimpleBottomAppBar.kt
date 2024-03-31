package com.example.movieappmad24.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movieappmad24.navigation.Screen

@Composable
fun SimpleBottomAppBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomAppBar(
        actions = {
            NavigationBarItem(
                selected = currentRoute == Screen.Home.route,
                onClick = {
                          navController.navigate(Screen.Home.route) {

                              launchSingleTop = true
                          }
                },
                icon = {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = "Home button"
                    )
                },
                label = {
                    Text(text = "Home")
                }
            )
            NavigationBarItem(
                selected = currentRoute == Screen.Watchlist.route,
                onClick = {
                    navController.navigate(Screen.Watchlist.route) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = "Watchlist"
                    )
                },
                label = {
                    Text(text = "Watchlist")
                }
            )
        }
    )
}