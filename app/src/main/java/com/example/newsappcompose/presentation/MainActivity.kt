package com.example.newsappcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsappcompose.models.presentation.Destinations
import com.example.newsappcompose.presentation.screens.FavouriteScreen
import com.example.newsappcompose.presentation.screens.HomeScreen
import com.example.newsappcompose.presentation.screens.SettingsScreen
import com.example.newsappcompose.presentation.theme.NewsAppComposeTheme
import com.example.newsappcompose.presentation.widgets.BottomBarWidget

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppComposeTheme {
                val navController: NavHostController = rememberNavController()
                val bottomBarHeight = 56.dp
                val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }

                var buttonsVisible = remember { mutableStateOf(true) }

                Scaffold(
                    bottomBar = {
                        BottomBarWidget(
                            navController = navController,
                            state = buttonsVisible,
                            modifier = Modifier
                        )
                    }) { paddingValues ->
                    Box(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        NavigationGraph(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Destinations.HomeScreen.route) {
        composable(Destinations.HomeScreen.route) {
            HomeScreen()
        }
        composable(Destinations.Favourite.route) {
            FavouriteScreen()
        }
        composable(Destinations.Settings.route) {
            SettingsScreen()
        }
    }
}
