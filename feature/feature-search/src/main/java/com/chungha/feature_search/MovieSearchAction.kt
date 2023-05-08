package com.chungha.feature_search

import com.chungha.core_domain.model.MovieModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

sealed interface SearchAction {

    fun reduce(state: MovieSearchState): MovieSearchState

    data class Search(val term: String) : SearchAction {
        override fun reduce(state: MovieSearchState): MovieSearchState {
            return state.copy(
                isLoading = true
            )
        }
    }
}

sealed interface SearchSideEffectAction : SearchAction {

    // Side Effect TextChange
    data class TextChanged(val term: String) : SearchSideEffectAction {
        override fun reduce(state: MovieSearchState): MovieSearchState = state
    }

    // Side Effect Search Remote
    data class SearchResult(
        val term: String,
        val resultSearch: PersistentList<MovieModel>? = null,
        val error: Throwable? = null
    ) : SearchSideEffectAction {
        override fun reduce(state: MovieSearchState): MovieSearchState = state.copy(
            isLoading = false,
            item = resultSearch ?: persistentListOf(),
            error = error
        )
    }
}