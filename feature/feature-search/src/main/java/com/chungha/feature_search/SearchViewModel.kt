package com.chungha.feature_search

import android.util.Log
import androidx.lifecycle.*
import com.chungha.core_domain.model.MovieModel
import com.chungha.core_domain.usecase.SearchMovieUseCase
import com.chungha.core_network.di.DispatcherProvider
import com.example.core_ui.widget.common.LceState
import com.preview.flowredux.flowFromSuspend
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchMovieUseCase: SearchMovieUseCase,
    dispatcher: DispatcherProvider,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val query = savedStateHandle.getStateFlow("Search","")

    private val _uiState = MutableStateFlow<LceState<List<MovieModel>>>(LceState.None)
    val uiState = _uiState.asStateFlow()

    init {
//        query
//            .filter { query -> query.trim().isEmpty().not() }
//            .debounce(300L)
//            .distinctUntilChanged()
//            .flatMapLatest { query ->
//                flowFromSuspend {
//                    searchMovieUseCase.invoke(query)
//                }
//            }
//            .catch { _uiState.value = LceState.Error(message = it.message.orEmpty()) }
//            .onEach {
//                _uiState.value = LceState.Success(it)
//            }.launchIn(viewModelScope)
    }

    fun queryTextChange(query: String) {
        if (query.trim().isNotEmpty()) {
            _uiState.value = LceState.Loading
        }
        savedStateHandle["Search"] = query
    }

}