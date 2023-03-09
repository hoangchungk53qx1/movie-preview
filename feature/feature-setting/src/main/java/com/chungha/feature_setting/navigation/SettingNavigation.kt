package com.chungha.feature_setting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.chungha.feature_setting.SettingRoute

const val settingRoute = "setting_route"

fun NavController.navigationSetting(navOptions: NavOptions) {
    this.navigate(settingRoute,navOptions)
}

fun NavGraphBuilder.settingScreen() {
    composable(route = settingRoute) {
        SettingRoute()
    }
}