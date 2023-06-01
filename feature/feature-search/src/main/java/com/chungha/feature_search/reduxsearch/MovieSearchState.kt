package com.chungha.feature_search.reduxsearch

import com.chungha.core_domain.model.MovieModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class MovieSearchState(
    val isLoading: Boolean = false,
    val item: PersistentList<MovieModel>,
    val error: Throwable? = null,
) {
    companion object {
        fun initialState(): MovieSearchState = MovieSearchState(
            isLoading = false,
            item = persistentListOf(),
            error = null
        )
    }
}
