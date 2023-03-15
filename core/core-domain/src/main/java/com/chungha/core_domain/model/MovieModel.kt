package com.chungha.core_domain.model

import com.chungha.core_network.Constants

data class MovieModel(
    val id: Int,
    val originalTitle: String,
    val posterPath: String?,
    val voteAverage: Double?,
    val voteCount: Int,
    val runtime: String? = null,
    val overview: String? = null
) {
    val fullMovieImagePath get() = "${Constants.IMAGE_URL}$posterPath"
}
