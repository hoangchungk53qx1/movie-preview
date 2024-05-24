package com.chungha.feature_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chungha.core_domain.model.HomeCategory
import com.chungha.core_domain.model.MovieModel
import com.chungha.core_domain.usecase.HomeMovieUseCase
import com.chungha.core_domain.usecase.TopRatedMovieUseCase
import com.example.core_data.utils.WhileSubscribedOrRetained
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class HomeViewModel @Inject constructor(
    movieUseCase: HomeMovieUseCase,
    topRatedMovieUseCase: TopRatedMovieUseCase
) : ViewModel() {

    // Holds our currently selected category
    private val _selectedCategory = MutableStateFlow(HomeCategory.NOW_PLAYING)

    val state: StateFlow<HomeViewState> = combine(
        topRatedMovieUseCase.invokeMovieTopRated(),
        _selectedCategory.flatMapLatest { selectedCategory ->
            movieUseCase.invokeMoviePlaying(selectedCategory)
        }
    ) { topRatedMovies, movies ->
        HomeViewState(
            isLoading = false,
            selectedCategory = _selectedCategory.value,
            topRatedMovies = topRatedMovies,
            movies = movies,
        )
    }.catch { throwable ->
        HomeViewState(
            isLoading = false,
            error = throwable,
        )
    }.stateIn(
        scope = viewModelScope,
        started = WhileSubscribedOrRetained,
        initialValue = HomeViewState()
    )

    fun onCategorySelected(category: HomeCategory) {
        _selectedCategory.value = category
    }
}

data class HomeViewState(
    val isLoading: Boolean = true,
    val error: Throwable? = null,
    val categories: List<HomeCategory> = HomeCategory.values().toList(),
    val selectedCategory: HomeCategory = HomeCategory.NOW_PLAYING,
    val topRatedMovies: List<MovieModel> = emptyList(),
    val movies: List<MovieModel> = emptyList(),
)
