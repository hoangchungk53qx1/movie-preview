package com.example.core_network.model.response

import com.example.core_network.Constants
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
