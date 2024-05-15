package com.example.core_data.repository

import com.chungha.core_domain.model.MovieModel
import com.chungha.core_domain.repository.MovieTopRatedRepository
import com.chungha.core_network.service.MovieService
import com.example.core_data.mapper.toMovieModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieTopRatedRepositoryImpl @Inject constructor(private val movieService: MovieService) :
    MovieTopRatedRepository {
    override suspend fun getTopRatedMovie(): List<MovieModel> {
        return movieService.getPlayingMovie().results.map { movie ->
            movie.toMovieModel()
        }
    }

}