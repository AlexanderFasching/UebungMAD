package com.example.movieappmad24.screens

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieappmad24.R
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies

@Composable
fun HomeScreen(navController: NavController, appName: String) {
    MovieAppScaffold(navController, appName)
}

@Composable
fun MovieList(navController: NavController, movies: List<Movie> = getMovies()){
    LazyColumn {
        items(movies) { movie ->
            MovieRow(movie) {
                navController.navigate(route = "detailscreen/${movie.id}")
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieRow(movie: Movie,
             onItemClick: (String) -> Unit = {}
){
    var showDetails by remember {
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearOutSlowInEasing
            )
        )
        .padding(5.dp)
        .clickable { onItemClick(movie.id) },
        shape = ShapeDefaults.Large,
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = movie.images[0],
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    contentAlignment = Alignment.TopEnd
                ){
                    Icon(
                        tint = MaterialTheme.colorScheme.secondary,
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Add to favorites")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = movie.title,
                    fontSize = 24.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Icon(modifier = Modifier
                    .clickable {
                        showDetails = !showDetails
                    },
                    imageVector =
                    if (showDetails) Icons.Filled.KeyboardArrowDown
                    else Icons.Default.KeyboardArrowUp, contentDescription = "show more")
            }
            if(showDetails) {
                Column(
                    Modifier.padding(horizontal = 10.dp)
                ) {
                    Text(text = movie.director)
                    Text(text = movie.year)
                    Text(text = movie.genre)
                    Text(text = movie.actors)
                    Text(text = movie.rating)
                    Divider()
                    Text(text = movie.plot)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(appName: String){
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(text = appName)
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieAppScaffold(navController: NavController, appName: String) {
    Scaffold(
        topBar = { TopBar(appName) },
        bottomBar = { BtmBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()

        ) {
            MovieList(navController = navController, movies = getMovies())
        }
    }
}
@Composable
fun BtmBar() {
    BottomAppBar(
        actions = {
            NavigationBarItem(
                selected = true,
                onClick = { /*TODO*/ },
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
                selected = false,
                onClick = { /*TODO*/ },
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