package com.chungha.core_domain.usecase

import com.chungha.core_domain.repository.PreviewRepository
import javax.inject.Inject

class PreviewMovieUseCase @Inject constructor(private val repository: PreviewRepository) {
    suspend fun getMovieById(id: Int) = repository.getMovieById(id = id)
}