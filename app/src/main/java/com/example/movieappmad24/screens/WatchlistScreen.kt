package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movieappmad24.composables.MovieList
import com.example.movieappmad24.composables.SimpleBottomAppBar
import com.example.movieappmad24.composables.SimpleTopAppBar
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MoviesViewModel
import com.example.movieappmad24.models.getMovies

@Composable
fun WatchlistScreen(navController: NavController, moviesViewModel: MoviesViewModel) {
    Scaffold(
        topBar = { SimpleTopAppBar(navController = navController, title = "Your Watchlist", back = false) },
        bottomBar = { SimpleBottomAppBar(navController = navController) }
    ) {
        innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            MovieList(navController = navController, moviesViewModel = moviesViewModel, movies = moviesViewModel.favoriteMovies)
        }
    }
}