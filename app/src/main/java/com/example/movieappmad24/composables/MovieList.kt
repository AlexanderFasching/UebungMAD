package com.example.movieappmad24.composables

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.MoviesViewModel
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.navigation.Screen

@Composable
fun MovieList(navController: NavController, moviesViewModel: MoviesViewModel, movies: List<Movie>){
    LazyColumn(
    ) {
        items(movies) { movie ->
            MovieRow(
                movie = movie,
                onFavClick = { movieId -> moviesViewModel.toggleFavoriteMovie(movieId) },
                onItemClick = { movieId -> navController.navigate(Screen.Details.createRoute(movieId)) }
            )
        }
    }
}