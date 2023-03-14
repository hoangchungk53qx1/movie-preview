package com.chungha.feature_search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chungha.core_domain.usecase.SearchMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchMovieUseCase: SearchMovieUseCase) : ViewModel() {

    init {
        viewModelScope.launch {
            searchMovieUseCase.invoke("bao").collect()
        }
    }

}