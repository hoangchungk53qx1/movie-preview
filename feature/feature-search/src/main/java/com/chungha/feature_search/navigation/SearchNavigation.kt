package com.chungha.feature_search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.chungha.feature_search.SearchRoute

const val searchRoute = "search_route"

fun NavController.navigationSearch(navOptions: NavOptions) {
    this.navigate(searchRoute,navOptions)
}

fun NavGraphBuilder.searchScreen() {
    composable(route = searchRoute) {
        SearchRoute()
    }
}