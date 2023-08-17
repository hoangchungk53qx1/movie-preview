package com.chungha.feature_preview.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.chungha.feature_preview.PreviewMovieRoute

const val previewMovieRoute = "preview_route"

fun NavController.navigationPreViewMovie(navOptions: NavOptions? = null) {
    this.navigate(route = previewMovieRoute, navOptions = navOptions)
}

fun NavGraphBuilder.previewMovieGraph() = composable(route = previewMovieRoute) {
    PreviewMovieRoute()
}