package com.chungha.core_domain.repository

import com.chungha.core_domain.model.MovieModel

interface SearchRepository {
    suspend fun search(query: String): List<MovieModel>
}