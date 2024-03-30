package com.example.movieappmad24.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen

@Composable
fun Navigation(appName: String) {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "homescreen") {
        composable(route = "homescreen") {
            HomeScreen(navController = navController, appName)
        }
        composable(route = "detailscreen/{movieId}",
            arguments = listOf(navArgument(name = "movieId") {type = NavType.StringType})
        ) {backStackEntry ->
            DetailScreen(movieId = backStackEntry.arguments?.getString("movieId"))
        }
    }
}