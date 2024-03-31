package com.example.movieappmad24.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SimpleBottomAppBar() {
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