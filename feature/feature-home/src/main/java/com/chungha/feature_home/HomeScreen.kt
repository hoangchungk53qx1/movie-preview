package com.chungha.feature_home

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    Box(contentAlignment = Alignment.Center) {
        Text(
            text = "HomeScreen",
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    }
}