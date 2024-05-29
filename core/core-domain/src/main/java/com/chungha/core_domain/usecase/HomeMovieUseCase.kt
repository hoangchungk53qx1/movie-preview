package com.chungha.core_domain.usecase

import com.chungha.core_domain.model.HomeCategory
import com.chungha.core_domain.model.MovieModel
import com.chungha.core_domain.repository.MoviePlayingRepository
import com.chungha.core_network.di.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeMovieUseCase @Inject constructor(
    private val moviePlayingRepository: MoviePlayingRepository,
    private val dispatcherProvider: DispatcherProvider,
) {
    fun invokeMoviePlaying(homeCategory: HomeCategory): Flow<List<MovieModel>> = flow {
        when (homeCategory) {
            HomeCategory.NOW_PLAYING -> {
                emit(moviePlayingRepository.getPlayingMovie())
            }

            HomeCategory.UPCOMING -> {
                emit(moviePlayingRepository.getUpcomingMovie())
            }

            HomeCategory.TOP_RATED -> {
                emit(moviePlayingRepository.getTopRatedMovie())
            }

            HomeCategory.POPULAR -> {
                emit(moviePlayingRepository.getPopularMovie())
            }
        }
    }.flowOn(dispatcherProvider.io)
}