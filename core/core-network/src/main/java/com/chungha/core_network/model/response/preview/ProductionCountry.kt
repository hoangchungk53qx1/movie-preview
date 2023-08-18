package com.chungha.core_network.model.response.preview

import com.chungha.core_network.Constants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductionCountry(
    @SerialName(Constants.Fields.NAME)
    val name: String,

    @SerialName(Constants.Fields.ISO_3166_1)
    val iso: String
)