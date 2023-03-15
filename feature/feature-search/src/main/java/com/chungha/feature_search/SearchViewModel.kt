package com.chungha.feature_search

import android.util.Log
import androidx.lifecycle.*
import com.chungha.core_domain.model.MovieModel
import com.chungha.core_domain.usecase.SearchMovieUseCase
import com.example.core_data.di.DispatcherProvider
import com.example.core_ui.widget.common.LceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchMovieUseCase: SearchMovieUseCase,
    dispatcher: DispatcherProvider
) : ViewModel() {

    private val _queryMovie = MutableLiveData<String>()
    val query: LiveData<String> = _queryMovie

    private val _uiState = MutableStateFlow<LceState<List<MovieModel>>>(LceState.None)
    val uiState = _uiState.asStateFlow()

    init {
        _queryMovie
            .asFlow()
            .flowOn(dispatcher.io)
            .filter { query -> query.trim().isEmpty().not() }
            .debounce(300L)
            .distinctUntilChanged()
            .catch { _uiState.value = LceState.Error(message = it.message.orEmpty()) }
            .flatMapLatest { query ->
                searchMovieUseCase.invoke(query)
            }
            .onEach {
                Log.d("SearchViewModel", it.toString())
                _uiState.value = LceState.Success(it)
            }
            .launchIn(viewModelScope)
    }

    fun queryTextChange(query: String) {
        _uiState.value = LceState.Loading
        _queryMovie.value = query
    }

}