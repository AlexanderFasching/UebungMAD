package com.example.movieappmad24.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.models.MoviesViewModel
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.screens.WatchlistScreen

@Composable
fun Navigation(appName: String) {
    val navController = rememberNavController()
    val movieViewModel: MoviesViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController, moviesViewModel = movieViewModel, appName)
        }
        composable(route = Screen.Details.route,
            arguments = listOf(navArgument(name = "movieId") {type = NavType.StringType})
        ) {backStackEntry ->
            DetailScreen(navController = navController, moviesViewModel = movieViewModel, movieId = backStackEntry.arguments?.getString("movieId"))
        }
        composable(route = Screen.Watchlist.route) {
            WatchlistScreen(navController = navController, moviesViewModel = movieViewModel)
        }
    }
}