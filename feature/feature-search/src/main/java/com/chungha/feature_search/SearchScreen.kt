package com.chungha.feature_search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SearchRoute(

) {
    SearchScreen()
}

@Composable
fun SearchScreen() {
    Box(contentAlignment = Alignment.Center) {
        Text(text = "SearchScreen")
    }

}