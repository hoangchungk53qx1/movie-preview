package com.chungha.feature_search.reduxsearch

import com.chungha.core_domain.usecase.SearchMovieUseCase
import com.chungha.flowredux.SideEffect
import com.preview.flowredux.flowFromSuspend
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlin.time.Duration.Companion.milliseconds

@OptIn(FlowPreview::class)
internal class MovieSearchSideEffects(private val searchMovieUseCase: SearchMovieUseCase) {

    inline val sideEffects
        get() = listOf<SideEffect<SearchAction, MovieSearchState>>(
            textChanged(),
            searchMovieText()
        )

    private fun textChanged() =
        SideEffect<SearchAction, MovieSearchState> { actionFlow, stateFlow, coroutineScope ->
            actionFlow
                .filterIsInstance<SearchAction.Search>()
                .map { it.term.trim() }
                .debounce(300.milliseconds)
                .filter { it.isNotBlank() }
                .distinctUntilChanged()
                .map { SearchSideEffectAction.TextChanged(term = it) }
        }

    private fun searchMovieText(): SideEffect<SearchAction, MovieSearchState> =
        SideEffect<SearchAction, MovieSearchState> { actionFlow, _, coroutineScope ->
            actionFlow.filterIsInstance<SearchSideEffectAction.TextChanged>()
                .flatMapLatest { action ->
                    executeSearchUseCase(action.term)
                }
        }

    private fun executeSearchUseCase(term: String): Flow<SearchSideEffectAction.SearchResult> =
        flowFromSuspend {
            val movieList = searchMovieUseCase.invoke(term)
            SearchSideEffectAction.SearchResult(
                term = term,
                resultSearch = movieList.toPersistentList(),
                error = null
            )
        }.catch { throwable ->
            emit(
                SearchSideEffectAction.SearchResult(
                    term = term,
                    resultSearch = null,
                    error = throwable
                )
            )
        }.onStart {

        }
}