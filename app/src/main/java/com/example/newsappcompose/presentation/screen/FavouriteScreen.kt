package com.example.newsappcompose.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.newsappcompose.presentation.viewmodel.FavouriteScreenViewModel

@Composable
fun FavouriteScreen(viewModel: FavouriteScreenViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Magenta)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Favourite Screen",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
        )
    }
}