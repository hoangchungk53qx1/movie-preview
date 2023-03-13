package com.chungha.feature_search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SearchRoute(
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    SearchScreen()
}

@Composable
fun SearchScreen() {
    Box(contentAlignment = Alignment.Center) {
        Text(text = "SearchScreen")
    }

}