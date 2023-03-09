package com.chungha.feature_home

sealed interface HomeEvent {
    object Refresh : HomeEvent

    object Retry : HomeEvent

    object Clear : HomeEvent
}
