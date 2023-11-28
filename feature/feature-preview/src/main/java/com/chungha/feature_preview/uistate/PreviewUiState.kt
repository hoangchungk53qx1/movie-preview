package com.chungha.feature_preview.uistate

import androidx.compose.runtime.Immutable
import com.chungha.core_domain.model.MovieDetailModel
import com.chungha.core_domain.model.MovieModel

@Immutable
data class PreviewUiState(
    val isLoading: Boolean,
    val error: Throwable? = null,
    val isOfflineModeAvailable: Boolean,
    val movieContent : MovieDetailModel? = null,
) {
    companion object {
        val INIT_STATE = PreviewUiState(
            isLoading = true,
            error = null,
            isOfflineModeAvailable = false,
        )
    }
}
