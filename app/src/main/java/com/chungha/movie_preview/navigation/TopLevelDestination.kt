package com.chungha.movie_preview.navigation

import com.chungha.movie_preview.R
import com.example.core_designsystem.icon.IconApp
import com.example.core_designsystem.icon.MoviePreviewIcons

enum class TopLevelDestination(
    val selectedIcon: IconApp,
    val unselectedIcon: IconApp,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    HOME(
        selectedIcon = IconApp.DrawableResourceIcon(MoviePreviewIcons.Home_Icon),
        unselectedIcon = IconApp.DrawableResourceIcon(MoviePreviewIcons.Home_Icon),
        iconTextId = R.string.home_title,
        titleTextId = R.string.app_name,
    ),
    SEARCH(
        selectedIcon = IconApp.DrawableResourceIcon(MoviePreviewIcons.Search_Icon),
        unselectedIcon = IconApp.DrawableResourceIcon(MoviePreviewIcons.Search_Icon),
        iconTextId = R.string.search_title,
        titleTextId = R.string.app_name,
    ),
    FAVOURITE(
        selectedIcon = IconApp.DrawableResourceIcon(MoviePreviewIcons.WishList_Icon),
        unselectedIcon = IconApp.DrawableResourceIcon(MoviePreviewIcons.WishList_Icon),
        iconTextId = R.string.wishlist_title,
        titleTextId = R.string.app_name,
    ),
    SETTING(
        selectedIcon = IconApp.DrawableResourceIcon(MoviePreviewIcons.Setting_Icon),
        unselectedIcon = IconApp.DrawableResourceIcon(MoviePreviewIcons.Setting_Icon),
        iconTextId = R.string.setting_title,
        titleTextId = R.string.app_name,
    )
}