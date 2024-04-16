package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappmad24.composables.ImageLazyRow
import com.example.movieappmad24.composables.MovieRow
import com.example.movieappmad24.composables.SimpleBottomAppBar
import com.example.movieappmad24.composables.SimpleTopAppBar
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MoviesViewModel
import com.example.movieappmad24.models.getMovies

@Composable
fun DetailScreen(navController: NavController, moviesViewModel: MoviesViewModel, movieId: String?) {
    val movie = moviesViewModel.movieList.find { it.id == movieId }
    if (movie != null) {
        Text(text = movie.id.toString())
    }
    DetailScreenScaffold(navController = navController, moviesViewModel= moviesViewModel, movie = movie)
}

@Composable
fun DetailScreenScaffold(navController: NavController, moviesViewModel: MoviesViewModel, movie: Movie?) {
    Scaffold(
        topBar = { SimpleTopAppBar(navController = navController, title = "Details", back = true) },
        bottomBar = { SimpleBottomAppBar(navController = navController) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()

        ) {
            Column {
                MovieRow(movie = movie, onFavClick = { movieId -> moviesViewModel.toggleFavoriteMovie(movieId) })
                ImageLazyRow(movie = movie)
            }
        }
    }
}