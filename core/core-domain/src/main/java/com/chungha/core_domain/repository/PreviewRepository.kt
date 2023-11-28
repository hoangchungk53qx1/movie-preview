package com.chungha.core_domain.repository

import com.chungha.core_domain.model.MovieDetailModel

interface PreviewRepository {
    suspend fun getMovieById(id : Int) : Result<MovieDetailModel>
}