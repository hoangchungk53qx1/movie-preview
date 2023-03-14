package com.chungha.core_domain.usecase

import com.chungha.core_domain.model.MovieModel
import com.chungha.core_domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchMovieUseCase @Inject constructor(private val searchRepository: SearchRepository) {

    suspend operator fun invoke(query: String) : Flow<List<MovieModel>> = flow {
       emit(searchRepository.search(query = query))
    }
}