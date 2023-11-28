package com.chungha.feature_preview

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chungha.core_domain.usecase.PreviewMovieUseCase
import com.chungha.feature_preview.uistate.PreviewUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PreviewViewModel @Inject constructor(
    private val previewMovieUseCase: PreviewMovieUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _previewMutableState = MutableStateFlow(PreviewUiState.INIT_STATE)
    val previewUiState = _previewMutableState.asStateFlow()

    private val movieId = savedStateHandle["idMovie"] ?: 1

    init {
        Log.d("PreviewViewModel", "movieId: $movieId")
        getDetailMovie()
    }


    private fun getDetailMovie() {
        viewModelScope.launch {
            previewMovieUseCase.getMovieById(movieId)
                .fold(
                    onSuccess = { movieDetailModel ->
                        _previewMutableState.update {
                            it.copy(isLoading = false, movieContent = movieDetailModel)
                        }
                    },
                    onFailure = { throwable ->
                        _previewMutableState.update {
                            it.copy(isLoading = false, error = throwable)
                        }
                    }
                )
        }
    }

}