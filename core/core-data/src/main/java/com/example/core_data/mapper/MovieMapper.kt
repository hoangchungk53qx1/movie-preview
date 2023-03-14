package com.example.core_data.mapper

import com.chungha.core_domain.model.MovieModel
import com.chungha.core_network.model.response.MovieResponse

fun MovieResponse.toMovieModel(): MovieModel {
    return MovieModel(
        id = id,
        originalTitle = originalTitle,
        posterPath = posterPath,
        voteAverage = voteAverage,
        voteCount = voteCount,
    )
}