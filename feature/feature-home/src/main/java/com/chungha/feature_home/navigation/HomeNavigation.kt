package com.chungha.feature_home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.chungha.feature_home.HomeRoute


const val homeNavigationRoute = "home_route"

fun NavHostController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(homeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(onTopicClick: (String) -> Unit) {
    composable(route = homeNavigationRoute) {
        HomeRoute()
    }
}