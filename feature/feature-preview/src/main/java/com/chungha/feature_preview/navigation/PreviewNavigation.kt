package com.chungha.feature_preview.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chungha.feature_preview.PreviewMovieRoute

const val previewMovieRoute = "preview_route"

const val previewMovieIdArgument = "$previewMovieRoute/{idMovie}"

fun NavController.navigationPreViewMovie(navOptions: NavOptions? = null, id: Int) {
    this.navigate(route = "$previewMovieRoute/$id", navOptions = navOptions)
}

fun NavGraphBuilder.previewMovieGraph() = composable(
    route = previewMovieIdArgument,
    arguments = listOf(
        navArgument("idMovie") {
            type = NavType.IntType
        }
    ),
) {
    PreviewMovieRoute()
}

