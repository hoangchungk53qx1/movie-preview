package com.example.core_data.repository

import android.util.Log
import com.example.core_data.mapper.toMovieModel
import com.chungha.core_network.service.SearchService
import com.chungha.core_domain.model.MovieModel
import com.chungha.core_domain.repository.SearchRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchMovieRepositoryImpl @Inject constructor(private val searchService: SearchService) :
    SearchRepository {
    override suspend fun search(query: String): List<MovieModel> =
        searchService.searchMovie(query).results.map { movie ->
            movie.toMovieModel()
        }
}