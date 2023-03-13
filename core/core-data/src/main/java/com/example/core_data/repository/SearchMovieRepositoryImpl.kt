package com.example.core_data.repository

import com.example.core_data.mapper.toMovieModel
import com.example.core_network.common.NetworkResponse
import com.example.core_network.model.response.MovieResponse
import com.example.core_network.service.SearchService
import domain.chungha.core_domain.model.MovieModel
import domain.chungha.core_domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchMovieRepositoryImpl @Inject constructor(private val searchService: SearchService) : SearchRepository {

    override suspend fun search(query: String): List<MovieModel> {
       return searchService.searchMovie(query).results.map {
            it.toMovieModel()
        }
    }
}