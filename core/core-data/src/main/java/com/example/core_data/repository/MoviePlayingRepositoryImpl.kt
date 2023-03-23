package com.example.core_data.repository

import com.chungha.core_domain.model.MovieModel
import com.chungha.core_domain.repository.MoviePlayingRepository
import com.chungha.core_network.service.MovieService
import com.example.core_data.mapper.toMovieModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviePlayingRepositoryImpl @Inject constructor(private val moviePlayingService: MovieService) :
    MoviePlayingRepository {
    override suspend fun getPlayingMovie(): List<MovieModel> {
        return moviePlayingService.getPlayingMovie().results.map { movie ->
            movie.toMovieModel()
        }
    }

}