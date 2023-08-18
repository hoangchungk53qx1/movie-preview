package com.example.core_data.mapper

import com.chungha.core_domain.model.CreditsModel
import com.chungha.core_domain.model.MovieDetailModel
import com.chungha.core_network.model.response.MoviePreviewResponse

fun MoviePreviewResponse.toMovieDetailModel(): MovieDetailModel {
    return MovieDetailModel(
        id = id,
        adult = adult,
        backdropPath = backdropPath,
        budget = budget,
        homepage = homepage,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        revenue = revenue,
        runtime = runtime,
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount,
        credits = CreditsModel(cast = listOf(), crew = listOf()),
        isWishlisted = false,
    )
}