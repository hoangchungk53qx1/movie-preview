package com.example.core_designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.chungha.movie_preview.core_designsystem.R

object MoviePreviewIcons {
     val Home_Icon = R.drawable.ic_home
     val Search_Icon = R.drawable.ic_search
     val WishList_Icon = R.drawable.ic_wishlist
     val Setting_Icon = R.drawable.ic_settings
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class IconApp {
    data class ImageVectorIcon(val imageVector: ImageVector) : IconApp()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : IconApp()
}
