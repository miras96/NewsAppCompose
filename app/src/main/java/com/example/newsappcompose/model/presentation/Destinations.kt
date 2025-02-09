package com.example.newsappcompose.model.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String? = null,
    val icon: ImageVector? = null
) {
    data object HomeScreen : Destinations(
        route = "home_screen",
        title = "Home",
        icon = Icons.Outlined.Home
    )

    data object Favourite : Destinations(
        route = "favourite_screen",
        title = "Favorite",
        icon = Icons.Outlined.FavoriteBorder
    )

    data object Settings : Destinations(
        route = "settings_screen",
        title = "Settings",
        icon = Icons.Outlined.Settings
    )

}