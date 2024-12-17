package com.example.newsappcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsappcompose.model.presentation.Destinations
import com.example.newsappcompose.presentation.screen.FavouriteScreen
import com.example.newsappcompose.presentation.screen.HomeScreen
import com.example.newsappcompose.presentation.screen.SettingsScreen
import com.example.newsappcompose.presentation.theme.NewsAppComposeTheme
import com.example.newsappcompose.presentation.viewmodel.FavouriteScreenViewModel
import com.example.newsappcompose.presentation.viewmodel.HomeScreenViewModel
import com.example.newsappcompose.presentation.viewmodel.SettingsScreenViewModel
import com.example.newsappcompose.presentation.widget.BottomBarWidget
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppComposeTheme {
                val navController: NavHostController = rememberNavController()
                val bottomBarHeight = 56.dp
                val bottomBarOffsetHeightPx = remember { mutableFloatStateOf(0f) }

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
            HomeScreen(hiltViewModel<HomeScreenViewModel>())
        }
        composable(Destinations.Favourite.route) {
            FavouriteScreen(hiltViewModel<FavouriteScreenViewModel>())
        }
        composable(Destinations.Settings.route) {
            SettingsScreen(hiltViewModel<SettingsScreenViewModel>())
        }
    }
}
