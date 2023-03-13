package com.example.core_network.common

import com.example.core_network.Constants
import com.example.core_network.model.response.MovieResponse
import kotlinx.serialization.SerialName

data class NetworkResponse<T>(
    @SerialName(Constants.Fields.PAGE)
    val page: Int,

    @SerialName(Constants.Fields.RESULTS)
    val results: T,

    @SerialName(Constants.Fields.TOTAL_PAGES)
    val totalPages: Int,

    @SerialName(Constants.Fields.TOTAL_RESULTS)
    val totalResults: Int,
)
