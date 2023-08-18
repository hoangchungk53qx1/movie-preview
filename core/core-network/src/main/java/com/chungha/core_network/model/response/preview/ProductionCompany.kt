package com.chungha.core_network.model.response.preview

import com.chungha.core_network.Constants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductionCompany(
    @SerialName(Constants.Fields.ID)
    val id: Int,

    @SerialName(Constants.Fields.NAME)
    val name: String,

    @SerialName(Constants.Fields.LOGO_PATH)
    val logoPath: String?,

    @SerialName(Constants.Fields.ORIGIN_COUNTRY)
    val originCountry: String
)