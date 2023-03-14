package com.chungha.feature_search

import androidx.lifecycle.*
import com.chungha.core_domain.model.MovieModel
import com.chungha.core_domain.usecase.SearchMovieUseCase
import com.example.core_data.LceState
import com.example.core_data.di.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
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
        queryTextChange("bao")
        _queryMovie
            .asFlow()
            .flowOn(dispatcher.io)
            .filter { query -> query.trim().isEmpty().not() }
            .debounce(300L)
            .distinctUntilChanged()
            .flatMapLatest { query ->
                searchMovieUseCase.invoke(query)
            }
            .onEach {
                _uiState.value = LceState.Success(it)
            }
            .launchIn(viewModelScope)
    }

    fun queryTextChange(query: String) {
        _queryMovie.value = query
    }

}