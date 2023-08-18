package com.chungha.feature_preview.uistate

sealed interface PreviewAction {

    data class Favorite(val idMovie: Int) : PreviewAction

    object Back : PreviewAction
}