package com.chungha.core_domain.repository

import com.chungha.core_domain.model.MovieModel

interface MovieTopRatedRepository {
    suspend fun getTopRatedMovie() : List<MovieModel>
}