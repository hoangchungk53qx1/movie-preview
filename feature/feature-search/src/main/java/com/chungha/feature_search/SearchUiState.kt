package com.chungha.feature_search

import com.chungha.core_domain.model.MovieModel

sealed class SearchUiState {
    object Loading : SearchUiState()
    object None : SearchUiState()
    data class Error(val message: String) : SearchUiState()
    data class SearchSuccess(val movieList: List<MovieModel> = emptyList())
}
