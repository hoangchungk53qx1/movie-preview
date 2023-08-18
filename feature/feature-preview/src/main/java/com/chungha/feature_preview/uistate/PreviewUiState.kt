package com.chungha.feature_preview.uistate

import androidx.compose.runtime.Immutable

@Immutable
data class PreviewUiState(
    val isLoading: Boolean,
    val error: Throwable? = null,
    val isOfflineModeAvailable: Boolean,
) {
    companion object {
        val INIT_STATE = PreviewUiState(
            isLoading = false,
            error = null,
            isOfflineModeAvailable = false,
        )
    }
}
