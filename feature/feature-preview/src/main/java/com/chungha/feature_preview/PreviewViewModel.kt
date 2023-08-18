package com.chungha.feature_preview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chungha.core_domain.usecase.PreviewMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PreviewViewModel @Inject constructor(private val previewMovieUseCase: PreviewMovieUseCase) : ViewModel() {

    init {
       viewModelScope.launch {

       }
    }
}