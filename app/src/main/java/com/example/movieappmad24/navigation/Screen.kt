package com.example.movieappmad24.navigation

sealed class Screen(val route: String) {
    object Home : Screen("homescreen")
    object Details : Screen("detailscreen/{movieId}") {
        fun createRoute(movieId: String) = "detailscreen/$movieId"
    }
    object Watchlist : Screen("watchlist")
}