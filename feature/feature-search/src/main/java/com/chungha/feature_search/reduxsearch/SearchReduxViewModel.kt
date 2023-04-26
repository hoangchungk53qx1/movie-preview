package com.chungha.feature_search.reduxsearch

import androidx.lifecycle.ViewModel
import com.chungha.core_domain.usecase.SearchMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchReduxViewModel @Inject constructor(
    private val searchMovieUseCase: SearchMovieUseCase,
) : ViewModel() {

}