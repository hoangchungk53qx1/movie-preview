package com.chungha.feature_search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.chungha.core_domain.usecase.SearchMovieUseCase
import com.chungha.feature_search.SearchRoute
import com.chungha.feature_search.reduxsearch.SearchReduxViewModel

const val searchRoute = "search_route"

fun NavController.navigationSearch(navOptions: NavOptions) {
    this.navigate(route = searchRoute, navOptions = navOptions)
}

fun NavGraphBuilder.searchScreen(navigateToPreview: (idMovie: Int) -> Unit) {
    composable(route = searchRoute) {
        SearchRoute(navigateToPreview = navigateToPreview)
    }
}