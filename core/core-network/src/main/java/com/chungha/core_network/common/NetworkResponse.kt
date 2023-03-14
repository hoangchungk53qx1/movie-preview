package com.chungha.core_network.common

import com.chungha.core_network.Constants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
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
