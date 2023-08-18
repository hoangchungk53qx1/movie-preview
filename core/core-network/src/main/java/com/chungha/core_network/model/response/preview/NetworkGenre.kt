package com.chungha.core_network.model.response.preview

import com.chungha.core_network.Constants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkGenre(
    @SerialName(Constants.Fields.ID)
    val id: Int,

    @SerialName(Constants.Fields.NAME)
    val name: String
)