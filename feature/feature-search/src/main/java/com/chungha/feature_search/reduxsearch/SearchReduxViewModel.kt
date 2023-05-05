package com.chungha.feature_search.reduxsearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chungha.core_domain.usecase.SearchMovieUseCase
import com.chungha.flowredux.createFlowReduxStore
import com.chungha.flowredux.flip
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SearchReduxViewModel @Inject constructor(
    searchMovieUseCase: SearchMovieUseCase,
) : ViewModel() {

    private val store = viewModelScope.createFlowReduxStore(
        initialState = MovieSearchState.initialState(),
        sideEffects = MovieSearchSideEffects(searchMovieUseCase).sideEffects,
        reducer = SearchAction::reduce.flip()
    )
//    private val store = viewModelScope.createFlowReduxStore(
//        initialState = MovieSearchState.initialState(),
//        sideEffects = MovieSearchSideEffects(searchMovieUseCase).sideEffects,
//        reducer = { state, action -> action.reduce(state) }
//    )

    val stateFlow = store.stateFlow

}

