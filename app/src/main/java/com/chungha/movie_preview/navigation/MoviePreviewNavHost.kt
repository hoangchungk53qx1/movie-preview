package com.chungha.movie_preview.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.chungha.feature_favourite.navigation.favouriteScreen
import com.chungha.feature_home.navigation.homeNavigationRoute
import com.chungha.feature_home.navigation.homeScreen
import com.chungha.feature_preview.navigation.navigationPreViewMovie
import com.chungha.feature_preview.navigation.previewMovieGraph
import com.chungha.feature_search.navigation.searchScreen
import com.chungha.feature_setting.navigation.settingScreen

/**
 * Top-level navigation graph. Navigation is organized as explained at
 * https://d.android.com/jetpack/compose/nav-adaptive
 *
 * The navigation graph defined in this file defines the different top level routes. Navigation
 * within each route is handled using state and Back Handlers.
 */
@Composable
fun MoviePreviewNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = homeNavigationRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen(onTopicClick = {})
        searchScreen(navigateToPreview = { id ->
            navController.navigationPreViewMovie(
                navOptions = null, id = id
            )
        })
        favouriteScreen()
        settingScreen()
        previewMovieGraph()
    }
}