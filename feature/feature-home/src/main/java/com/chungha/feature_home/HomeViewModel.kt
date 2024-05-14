package com.chungha.feature_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chungha.core_domain.model.MovieModel
import com.chungha.core_domain.usecase.HomeMovieUseCase
import com.chungha.core_network.di.DispatcherProvider
import com.example.core_data.utils.WhileSubscribedOrRetained
import com.example.core_ui.widget.common.LceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieUseCase: HomeMovieUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    val homeUiState =
        movieUseCase.invokeMovieTopRated()
            .onStart {  }
            .onCompletion {  }
            .catch {  }
            .flowOn(dispatcherProvider.main)
            .stateIn(scope = viewModelScope, started = WhileSubscribedOrRetained, initialValue = emptyList())
}