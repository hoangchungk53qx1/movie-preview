package com.example.core_ui.widget.common

fun <T> showLoadingLceState(
    uiState: LceState<T>
): Boolean = when (uiState) {
    is LceState.Error -> false
    is LceState.Success -> false
    LceState.Loading -> true
    LceState.None -> false
}

fun <T> getValueLceOrNull(
    uiState: LceState<T>
): T? = if (uiState is LceState.Success) {
    uiState.item
} else {
    null
}