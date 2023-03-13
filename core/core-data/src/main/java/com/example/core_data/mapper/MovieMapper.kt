package com.example.core_data.mapper

import com.example.core_network.model.response.MovieResponse
import domain.chungha.core_domain.model.MovieModel

fun MovieResponse.toMovieModel(): MovieModel {
    return MovieModel(
        id = id,
        originalTitle = originalTitle,
        posterPath = posterPath,
        voteAverage = voteAverage,
        voteCount = voteCount,
    )
}