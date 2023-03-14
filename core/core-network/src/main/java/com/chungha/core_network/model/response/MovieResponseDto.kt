package com.chungha.core_network.model.response

import com.chungha.core_network.Constants
import com.chungha.core_network.model.response.MovieResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponseDto(
    @SerialName(Constants.Fields.PAGE)
    val page: Int,

    @SerialName(Constants.Fields.RESULTS)
    val results: List<MovieResponse>,

    @SerialName(Constants.Fields.TOTAL_PAGES)
    val totalPages: Int,

    @SerialName(Constants.Fields.TOTAL_RESULTS)
    val totalResults: Int,
)
