package com.chungha.feature_favourite.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val favouriteRoute = "favourite_route"

fun NavController.navigationFavourite(navOptions: NavOptions) {
    this.navigate(favouriteRoute,navOptions)
}

fun NavGraphBuilder.favouriteScreen() {
    composable(route = favouriteRoute) {

    }
}