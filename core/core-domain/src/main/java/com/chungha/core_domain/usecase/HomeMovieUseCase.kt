package com.chungha.core_domain.usecase

import com.chungha.core_domain.model.MovieModel
import com.chungha.core_domain.repository.MoviePlayingRepository
import com.chungha.core_network.di.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeMovieUseCase @Inject constructor(
    private val moviePlayingRepository: MoviePlayingRepository,
    private val dispatcherProvider: DispatcherProvider
) {
    fun invokeMoviePlaying(): Flow<List<MovieModel>> = flow {
        emit(moviePlayingRepository.getPlayingMovie())
    }.flowOn(dispatcherProvider.io)
}